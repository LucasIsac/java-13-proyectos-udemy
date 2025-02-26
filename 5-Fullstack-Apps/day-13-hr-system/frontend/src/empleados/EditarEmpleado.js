import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditarEmpleado() {
  const urlBase = "http://localhost:8080/rh-app/empleados";
  const { id } = useParams();

  const [empleado, setEmpleado] = useState({
    nombre: "",
    departamento: "",
    sueldo: "",
  });

  const { nombre, departamento, sueldo } = empleado;

  useEffect(() => {
    cargarEmpleados();
  }, []);

  const cargarEmpleados = async () => {
    const resultado = await axios.get(`${urlBase}/${id}`);
    setEmpleado(resultado.data);
  };

  const onInputChange = (e) => {
    //spread operator ... (expandir los atributos del objeto)
    setEmpleado({ ...empleado, [e.target.name]: e.target.value });
  };

  let navegacion = useNavigate();

  const onSubmit = async (e) => {
    e.preventDefault(); //evita que los datos se coloquen en el url
    await axios.put(`${urlBase}/${id}`, empleado);
    //Rederigimos a inicio
    navegacion("/");
  };

  return (
    <div classNameName="container">
      <div classNameName="container text-center" style={{ margin: "30px" }}>
        <h3>Editar Empleado</h3>
      </div>
      <form onSubmit={(e) => onSubmit(e)}>
        <div className="mb-3">
          <label htmlFor="nombre" className="form-label">
            Nombre
          </label>
          <input
            type="text"
            className="form-control"
            id="nombre"
            name="nombre"
            required={true}
            value={nombre}
            onChange={(e) => onInputChange(e)}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="departamento" className="form-label">
            Departamento
          </label>
          <input
            type="text"
            className="form-control"
            id="departamento"
            name="departamento"
            value={departamento}
            onChange={(e) => onInputChange(e)}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="sueldo" className="form-label">
            Sueldo
          </label>
          <input
            type="number"
            className="form-control"
            id="sueldo"
            name="sueldo"
            value={sueldo}
            onChange={(e) => onInputChange(e)}
          />
        </div>
        <div className="text-center">
          <button type="submit" className="btn btn-warning btn-sm me-3">
            Guardar
          </button>
          <Link to="/" className="btn btn-danger btn-sm">
            Regresar
          </Link>
        </div>
      </form>
    </div>
  );
}
