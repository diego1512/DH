-- 1 Queremos tener un listado de todas las categorías.
select CategoriaID, CategoriaNombre from categorias 
order by CategoriaID;

-- 2 Cómo las categorías no tienen imágenes, solamente interesa obtener un listado de CategoriaNombre y Descripcion.

select CategoriaNombre, Descripcion from categorias;

-- 3 Obtener un listado de los productos.
select ProductoID, ProductoNombre from productos 
order by ProductoID;
-- 4 	¿Existen productos discontinuados? (Discontinuado = 1).

select ProductoID, ProductoNombre, Discontinuado from productos 
where Discontinuado = 1
order by ProductoID;
-- 5 Para el viernes hay que reunirse con el Proveedor 8. ¿Qué productos son los que nos provee?
select ProductoID, ProductoNombre, ProveedorID from productos 
where ProveedorID = 8
order by ProductoID;
-- 6 Queremos conocer todos los productos cuyo precio unitario se encuentre entre 10 y 22.
select ProductoID, ProductoNombre, PrecioUnitario from productos 
where PrecioUnitario BETWEEN 10 AND 22 
order by PrecioUnitario;
-- 7 Se define que un producto hay que solicitarlo al proveedor si sus unidades en stock son menores al Nivel de Reorden. ¿Hay productos por solicitar?
select ProductoID, ProductoNombre, UnidadesStock, NivelReorden from productos 
where UnidadesStock < NivelReorden
order by UnidadesStock;
-- 8 Se quiere conocer todos los productos del listado anterior, pero que unidades pedidas sea igual a cero.
select ProductoID, ProductoNombre, UnidadesStock, NivelReorden, unidadesPedidas from productos 
where UnidadesStock < NivelReorden and unidadesPedidas 	= 0 
order by UnidadesStock;

-- CLIENTES 
-- 1 Obtener un listado de todos los clientes con Contacto, Compania, Título, País. Ordenar el listado por País.
select ClienteID, Contacto, Compania, Titulo, Pais from clientes 
order by Pais;
-- 2 Queremos conocer a todos los clientes que tengan un título “Owner”.
select ClienteID, Titulo from clientes 
where Titulo = "Owner"
order by ClienteID;

-- 3 El operador telefónico que atendió a un cliente no recuerda su nombre. Solo sabe que comienza con “C”. ¿Lo ayudamos a obtener un listado con todos los contactos que inician con la letra “C”?
select ClienteID, Contacto from clientes 
where Contacto  like 'c%'
order by ClienteID;

-- Facturas 
-- 1 Obtener un listado de todas las facturas, ordenado por fecha de factura ascendente.
select FacturaID, FechaFactura from facturas 
order by FechaFactura;

-- Ahora se requiere un listado de las facturas con el país de envío “USA” y
-- que su correo (EnvioVia) sea distinto de 3.

select facturaID,PaisEnvio, EnvioVia from facturas 
where PaisEnvio = "USA" and EnvioVia = 3;


-- ¿El cliente 'GOURL' realizó algún pedido?

select * from facturas 
where clienteID = "GOURL";

-- Se quiere visualizar todas las facturas de los empleados 2, 3, 5, 8 y 9.
select FacturaID from facturas
where EmpleadoID in (2, 3, 5, 8,9);

-- <PRODUCTOS>
-- Productos
-- 1. Obtener el listado de todos los productos ordenados
-- descendentemente por precio unitario.

select ProductoNombre as Producto from productos
order by PrecioUnitario desc;

-- 2. Obtener el listado de top 5 de productos cuyo precio unitario es
-- el más caro.
select ProductoID as ID, ProductoNombre as Producto, PrecioUnitario as Precio from productos
group by PrecioUnitario desc
limit 5;

-- 3. Obtener un top 10 de los productos con más unidades en stock.
select ProductoID as ID, ProductoNombre as Producto, UnidadesStock as Stockfrom from productos
order by UnidadesStock desc
limit 10;
-- FacturaDetalle
-- 1 Obtener un listado de FacturaID, Producto, Cantidad.
select FacturaID,ProductoID, Cantidad from facturadetalle;

-- 2. Ordenar el listado anterior por cantidad descendentemente.
select FacturaID,ProductoID, Cantidad from facturadetalle
order by Cantidad desc;
-- 3. Filtrar el listado solo para aquellos productos donde la cantidad se encuentre entre 50 y 100.
select FacturaID, ProductoID, Cantidad from  facturadetalle
where Cantidad BETWEEN 50 AND 100 
order by Cantidad;
-- 4. En otro listado nuevo, obtener un listado con los siguientes nombres de columnas: NroFactura (FacturaID), Producto (ProductoID), Total (PrecioUnitario*Cantidad).
select FacturaID AS NroFactura, ProductoID AS Producto , PrecioUnitario*Cantidad AS Total from  facturadetalle
order by Total;
