import { useEffect, useState } from "react";

function App() {
  const [buses, setBuses] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  const verDetalle = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/bus/${id}`, {
        headers: {
          "Authorization": "Basic " + btoa("admin:1234")
        }
      });
      if (!response.ok) throw new Error("No se pudo obtener el detalle");

      const bus = await response.json();

      const mensaje = `
  DETALLE DEL VEHÍCULO
  ---------------------------------------
  ID: ${bus.id}
  Número de Bus: ${bus.numeroBus}
  Placa: ${bus.placa}
  Marca: ${bus.marca?.nombre || 'No asignada'}
  Características: ${bus.caracteristicas || 'Sin especificar'}
  Fecha Registro: ${bus.fechaCreacion || 'No disponible'}
  Estado: ${bus.activo ? "ACTIVO" : "INACTIVO"}
  ---------------------------------------
      `;

      alert(mensaje);
    } catch (error) {
      console.error("Error:", error);
      alert("Hubo un error al conectar con el servidor.");
    }
  };

  useEffect(() => {
    fetch(`http://localhost:8080/bus?page=${page}&size=5`, {
      headers: {
        "Authorization": "Basic " + btoa("admin:1234")
      }
    })
      .then(res => res.json())
      .then(data => {
        setBuses(data.content);
        setTotalPages(data.totalPages);
      });
  }, [page]);

  return (
    <div style={{ padding: "20px" }}>
      <h2>Lista de Buses</h2>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>ID</th>
            <th>Número</th>
            <th>Placa</th>
            <th>Marca</th>
            <th>Activo</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {buses.map(bus => (
            <tr key={bus.id}>
              <td>{bus.id}</td>
              <td>{bus.numeroBus}</td>
              <td>{bus.placa}</td>
              <td>{bus.marca?.nombre}</td>
              <td>{bus.activo ? "Sí" : "No"}</td>
              <td>
                <button onClick={() => verDetalle(bus.id)} style={{ cursor: 'pointer', padding: '5px 10px' }}>Ver</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div style={{ marginTop: "10px" }}>
        <button 
          onClick={() => setPage(page - 1)} 
          disabled={page === 0}
        >
          Anterior
        </button>
              
        <span style={{ margin: "0 10px" }}>
          Página {page + 1} de {totalPages}
        </span>
              
        <button 
          onClick={() => setPage(page + 1)} 
          disabled={page + 1 >= totalPages}
        >
          Siguiente
        </button>
      </div>
    </div>
  );
}

export default App;