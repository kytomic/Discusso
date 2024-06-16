import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Login from './page/Login';
import Register from './page/Register';
import Main from './page/Main';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path='/' element={<Login/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/register' element={<Register/>}/>
        <Route path='/main' element={<Main/>}/>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
