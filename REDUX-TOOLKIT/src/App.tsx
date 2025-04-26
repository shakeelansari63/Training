import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Todos from "./components/Todos";
import AddTodo from "./components/AddTodo";
function App() {
    const [count, setCount] = useState(0);

    return (
        <>
            <div className="App">Testing React with Redux</div>
            <AddTodo></AddTodo>
            <Todos></Todos>
        </>
    );
}

export default App;
