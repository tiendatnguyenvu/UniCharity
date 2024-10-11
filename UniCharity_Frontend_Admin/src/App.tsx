
import { RouterProvider  as Routers} from 'react-router-dom'
import './App.css'
import Router from './routes/Router';
function App() {

  return (
    <>
     <Routers router={Router}/>
    </>
  );
}

export default App
