const archivos = require("./lecturaEscritura");
let arrayDepartamentos = archivos.leerJson("departamentos");

let inmobiliaria = {
  departamentos: arrayDepartamentos,
  //2B
  listarDepartamentos: function (arrayDepartamentos) {
    arrayDepartamentos.forEach((departamento) => {
      let estado = departamento.disponible ? "Disponible" : "Alquilado";
      console.log(
        `id: ${departamento.id}, precio: $ ${departamento.precioAlquiler}, está ${estado}, ${departamento.ambientes} ambientes`
      );
    });
  },

  //2C
  buscarPorId: function (id) {
    return this.departamentos.find((departamento) => departamento.id === id);
  },
  //2D
  departamentosNoDisponibles: function () {
    return this.departamentos.filter(
      (departamento) => !departamento.disponible
    );
  },

  //2E
  departamentosDisponibles: function () {
    return this.departamentos.filter((departamento) => departamento.disponible);
  },

  //2F
  filtrarPorAmbientes: function (ambientes) {
    return this.departamentos.filter(
      (departamento) => departamento.ambientes >= ambientes
    );
  },

  //2G
  filtrarPorPrecio: function (precio) {
    return this.departamentos.filter(
      (departamento) => departamento.precioAlquiler <= precio
    );
  },

  //2H
  rebajarPrecio: function (porcentaje) {
    const deptosDisponibles = this.departamentosDisponibles();
    deptosDisponibles.forEach((departamento) => {
      departamento.precioAlquiler -=
        departamento.precioAlquiler * (porcentaje / 100);
    });
    archivos.escribirJson('departamentos',this.departamentos)
    return deptosDisponibles;
  },
  //2I
  calcularRecaudacion: function(){
    if(this.departamentosNoDisponibles()){
      return this.departamentosNoDisponibles().reduce((acc,depto)=>acc + depto.precioAlquiler , 0)
    }
  },

  //2I
  ordenarPorPrecio: function(arrayDepartamentos = this.departamentos){
    return arrayDepartamentos.sort((a,b) => a.precioAlquiler-b.precioAlquiler)
  }
};

/*EJ 2B*/
/* console.log("****** dptos *****");
inmobiliaria.listarDepartamentos(inmobiliaria.departamentos);
console.log(); */

/* EJ 2C*/
/* console.log("***** buscarpor ID *****");
console.log(inmobiliaria.buscarPorId(17));
console.log(); */

// /* EJ 2D */
/* console.log("***** No disponibles *****");
inmobiliaria.listarDepartamentos(inmobiliaria.departamentosNoDisponibles())
console.log(); */

// /* EJ 2E */
/* console.log("***** disponibles *****");
inmobiliaria.listarDepartamentos(inmobiliaria.departamentosDisponibles())
console.log(); */

// /* EJ 2F*/
/* console.log("***** Filtrar Por Ambientes *****");
inmobiliaria.listarDepartamentos(inmobiliaria.filtrarPorAmbientes(1))
console.log();
 */
// /* EJ 2F*/
/* console.log("***** Filtrar Por Precio *****");
inmobiliaria.listarDepartamentos(inmobiliaria.filtrarPorPrecio(28000))
console.log();
 */

// /* EJ 2H*/
/* console.log("***** Rebajar Precio *****");
inmobiliaria.listarDepartamentos(inmobiliaria.rebajarPrecio(3));
console.log();
 */

// /* EJ 2I*/
/* console.log("***** Calcular Recaudacion *****");
console.log(inmobiliaria.calcularRecaudacion());
console.log(); */

// /* EJ 2J*/
/* console.log("***** Ordenar Por Precio *****");
inmobiliaria.listarDepartamentos(inmobiliaria.ordenarPorPrecio(inmobiliaria.departamentos));
console.log();
 */