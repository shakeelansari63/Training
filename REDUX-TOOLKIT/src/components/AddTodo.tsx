import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { addTodo } from "../store/features/todo/todo-slice";

function AddTodo() {
    const [input, setInput] = useState("");
    const dispatch = useDispatch();

    const addTodoHandler = (e: React.FormEvent) => {
        e.preventDefault();
        dispatch(addTodo(input));
        setInput("");
    };

    return (
        <form onSubmit={addTodoHandler}>
            <input type="text" value={input} onChange={(e) => setInput(e.target.value)} />
            <button type="submit">+ Add Todo</button>
        </form>
    );
}

export default AddTodo;
