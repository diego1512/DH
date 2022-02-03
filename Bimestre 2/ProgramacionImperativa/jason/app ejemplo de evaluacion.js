const v = "\x1b[32m%s\x1b[0m"; // NO TOCAR
const o = "*".repeat(80) + "\n"; // NO TOCAR
const oo = "*".repeat(25); // NO TOCAR

/*******************************/
/* Desarrollo de las consignas */
/*******************************/
const jsonHelper = require("./jsonHelper");
// A
const carrera = {
  // B
  bicicletas: jsonHelper.leerJson("bicicletas"),
  // C
  bicicletasPorTanda: 4,
  // D
  listarBicicletas: function (arrayBicis) {
    arrayBicis.forEach((bici) => {
      let estado = bici.dopaje ? "inhabilitado" : "habilitado";
      console.log(
        `Ciclista: ${bici.ciclista}, marca: ${bici.marca}, rodado: ${bici.rodado}, peso: ${bici.peso}kg, largo: ${bici.largo}cm, estado: ${estado}.`
      );
    });
  },
  // E
  ciclistasHabilitados: function () {
    // return this.bicicletas.filter((bici) => !bici.dopaje);
    let habilitados = this.bicicletas.filter((bici) => !bici.dopaje);
    return habilitados;
  },
  // F
  buscarPorId: function (id) {
    return this.bicicletas.find((bici) => bici.id === id);
  },
  // G
  filtrarPorPeso: function (peso) {
    //   let habilitados = this.ciclistasHabilitados()
    //   return habilitados.filter((bici) => bici.peso <= peso)
    return this.ciclistasHabilitados().filter((bici) => bici.peso <= peso);
  },
  // H
  ordenarPorRodado: function () {
    return this.bicicletas.sort((a, b) => a.rodado - b.rodado);
  },
  // I
  largoPromedio: function () {
    let sumatoria = this.bicicletas.reduce(
      (acum, bici) => acum + bici.largo,
      0
    );
    let promedio = sumatoria / this.bicicletas.length;
    return `El largo promedio de las bicicletas es de: ${promedio.toFixed(
      2
    )}cm`;
  },
  // J
  aumentarPeso: function (peso, id) {
    let biciEncontrada = this.buscarPorId(id);
    if (biciEncontrada) {
      biciEncontrada.peso += peso;
      jsonHelper.escribirJson("bicicletas", this.bicicletas);
    }
  },
  // K
  generarTanda: function (rodado, peso) {
    let filtrados = this.ciclistasHabilitados().filter(
      (bici) => bici.rodado <= rodado && bici.peso >= peso
    );
    return filtrados.slice(0, this.bicicletasPorTanda);
  },
  // L
  calcularPodio: function (tanda) {
    tanda.sort((a, b) => b.puntaje - a.puntaje);
    let primero = tanda[0];
    let segundo = tanda[1];
    let tercero = tanda[2];

    console.log(
      `El ganador es: ${primero.ciclista}, con un puntaje de: ${primero.puntaje}.
      El segundo puesto es para ${segundo.ciclista}, con un puntaje de ${segundo.puntaje}.
      El tercer puesto es para ${tercero.ciclista}, con un puntaje de ${tercero.puntaje}.`
    );
  },
};
/******************************/
/* Ejecución de las consignas */
/******************************/

console.log(v, "\n" + oo + " .D. ");
// Ejecución aquí
carrera.listarBicicletas(carrera.bicicletas);
console.log(o);

console.log(v, oo + " .E.");
// Ejecución aquí
carrera.listarBicicletas(carrera.ciclistasHabilitados());
console.log(o);

console.log(v, oo + " .F.");
// Ejecución aquí
console.log(carrera.buscarPorId(3));
console.log(o);

console.log(v, oo + " .G.");
// Ejecución aquí
carrera.listarBicicletas(carrera.filtrarPorPeso(8));
// console.log(carrera.filtrarPorPeso(2));
console.log(o);

console.log(v, oo + " .H.");
// Ejecución aquí
carrera.listarBicicletas(carrera.ordenarPorRodado());
console.log(o);

console.log(v, oo + " .I.");
// Ejecución aquí
console.log(carrera.largoPromedio());
console.log(o);

console.log(v, oo + " .J. ");
// Ejecución aquí
console.log(carrera.buscarPorId(1));
carrera.aumentarPeso(10, 1);
console.log(carrera.buscarPorId(1));
console.log(o);

console.log(v, oo + " .K. ");
// Ejecución aquí
carrera.listarBicicletas(carrera.generarTanda(26, 8));
console.log(o);

console.log(v, oo + " .L. ");
// Ejecución aquí
carrera.calcularPodio(carrera.generarTanda(26, 8));
console.log(o);
