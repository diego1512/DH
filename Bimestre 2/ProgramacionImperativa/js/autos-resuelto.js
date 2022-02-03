const jsonHelper = require("./lecturaEscritura");

// 2. Crear un objeto literal que represente la carrera
const carrera = {
  // 2.A.
  autos: jsonHelper.leerJson("autos"),

  // 2.B.
  autosPorTanda: 6,

  // 2.C.
  autosHabilitados: function () {
    return this.autos.filter((auto) => !auto.sancionado);
  },

  // 2.D.
  listarAutos: function (arrayAutos) {
    arrayAutos.forEach((auto) => {
      let estado = auto.sancionado ? "sancionado" : "habilitado";
      console.log(
        `Piloto: ${auto.piloto}, patente: ${auto.patente}, velocidad: ${auto.velocidad}km/h, peso en kg: ${auto.peso}Kg, estado: ${estado}.`
      );
    });
  },

  // 2.E.
  buscarPorPatente: function (patente) {
    return this.autos.find((auto) => auto.patente === patente);
  },

  // 2.F.
  filtrarPorCilindrada(cilindrada) {
    let autosHabilitados = this.autosHabilitados();
    return autosHabilitados.filter((auto) => auto.cilindrada <= cilindrada);
  },

  // 2.G.
  ordenarPorVelocidad: function () {
    return this.autos.sort((a, b) => a.velocidad - b.velocidad);
  },
  // 2.H.
  habilitarVehiculo: function (patente) {
    let auto = this.buscarPorPatente(patente);
    if (auto) {
      auto.sancionado = false;
      jsonHelper.escribirJson("autos", this.autos);
    }
    return auto;
  },
  // 2.I.
  generarTanda: function (cilindrada, peso) {
    let habilitadosPorCilindrada = this.filtrarPorCilindrada(cilindrada);
    let filtrados = habilitadosPorCilindrada.filter(
      (auto) => auto.peso <= peso
    );
    let tanda = filtrados.slice(0, this.autosPorTanda);
    return tanda;
  },
  // 2.J.
  pesoPromedio: function (cilindrada, peso) {
    let tanda = this.generarTanda(cilindrada, peso);
    let sumatoria = tanda.reduce((acum, auto) => acum + auto.peso, 0);
    let promedio = sumatoria / this.generarTanda(cilindrada, peso).length;
    return `El peso promedio de la tanda de vehiculos es de: ${promedio}Kg`;
  },
  // 2.K.
  listarPodio: function (tanda) {
    let tandaDeMayorAMenor = tanda.sort((a, b) => b.puntaje - a.puntaje);
    let primero = tandaDeMayorAMenor[0];
    let segundo = tandaDeMayorAMenor[1];
    let tercero = tandaDeMayorAMenor[2];

    console.log(
      `El primero es ${primero.piloto} con un puntaje de ${primero.puntaje}`
    );
    console.log(
      `El segundo puesto es para ${segundo.piloto} con un puntaje de ${segundo.puntaje}`
    );
    console.log(
      `El tercer puesto es para ${tercero.piloto} con un puntaje de ${tercero.puntaje}`
    );
  },
};

/* EJ 2.C. */
console.log("****** autosHabilitados *****");
carrera.listarAutos(carrera.autosHabilitados());
console.log("*******************");

/* EJ 2.D. */
console.log("***** listarAutos *****");
carrera.listarAutos(carrera.autos);
console.log("*******************");

/* EJ 2.E. */
console.log("***** buscarPorPatente *****");
console.log(carrera.buscarPorPatente("JHV223"));
console.log("*******************");

/* EJ 2.F. */
console.log("***** filtrarPorCilindrada ******");
carrera.listarAutos(carrera.filtrarPorCilindrada(1500));
console.log("*******************");

/* EJ 2.G. */
console.log("****** ordenarPorVelocidad ******");
carrera.listarAutos(carrera.ordenarPorVelocidad());
console.log("*******************");

/* EJ 2.H. */
console.log("****** habilitarVehiculo ******");
console.log(carrera.habilitarVehiculo("JHV223"));
console.log("*******************");

/* EJ 2.I. */
console.log("****** generarTanda ******");
carrera.listarAutos(carrera.generarTanda(2000, 2000));
console.log("*******************");

// /* EJ 2.J. */
console.log("****** pesoPromedio ******");
console.log(carrera.pesoPromedio(2000, 2000));
console.log("*******************");

/* EJ 2.K. */
console.log("****** listarPodio ******");
carrera.listarPodio(carrera.generarTanda(1500, 2000));
console.log("*******************");
