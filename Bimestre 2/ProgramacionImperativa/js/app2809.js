const jsonHelper = require("./lecturaEscritura");

const carrera = {
  autos: jsonHelper.leerJson("autos"),
  autosPorTanda: 6,
  autosHabilitados: function () {
    return this.autos.filter((auto) => auto.sancionado === false);
  },
  listarAutos: function (arrayAutos) {
    arrayAutos.forEach((auto) => {
      let estado = auto.sancionado ? "sancionado" : "habilitado";
      console.log(
        `Piloto: ${auto.piloto}, patente: ${auto.patente}, velocidad: ${auto.velocidad}km/h, peso en kg: ${auto.peso}, estado: ${estado}.`
      );
    });
  },
  buscarPorPatente: function (patente) {
    return this.autos.find((auto) => auto.patente === patente);
  },
  ordernarPorVelocidad: function () {
    return this.autos.sort((autoA, autoB) => autoA.velocidad - autoB.velocidad);
  },
  pesoPromedio: function () {
    let habilitados = this.autosHabilitados();
    let sumatoria = habilitados.reduce((acum, auto) => acum + auto.peso, 0);
    let promedio = sumatoria / habilitados.length;
    return `El peso promedio de los vehiculos es de: ${promedio}Kg`;
  },
};

// carrera.listarAutos(carrera.autos);
// carrera.listarAutos(carrera.autosHabilitados());
// console.log(carrera.buscarPorPatente("MMN771"));
// let autoEncontrado = carrera.buscarPorPatente("MMN771");
// carrera.listarAutos([autoEncontrado]);

// carrera.listarAutos(carrera.ordernarPorVelocidad());
console.log(carrera.pesoPromedio());
