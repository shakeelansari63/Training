import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { removeTodo } from "../store/features/todo/todo-slice";
import { StoreState, Todo } from "../store/features/todo/model";

function Todos() {
    const todos = useSelector<StoreState, Todo[]>((state) => state.todos);
    const dispatch = useDispatch();

    return (
        <div>
            {todos.map((todo) => (
                <li key={todo.id}>
                    {todo.text} <button onClick={() => dispatch(removeTodo(todo.id))}>X</button>
                </li>
            ))}
        </div>
    );
}

export default Todos;
