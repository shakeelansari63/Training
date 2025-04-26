import { createSlice, nanoid } from "@reduxjs/toolkit";
import { StoreState } from "./model";

const initialState: StoreState = {
    todos: [],
};

const todoSlice = createSlice({
    name: "todo",
    initialState: initialState,
    reducers: {
        addTodo: (state, action) => {
            const newTodo = {
                id: nanoid(),
                text: action.payload,
            };
            state.todos.push(newTodo);
        },
        removeTodo: (state, action) => {
            state.todos = state.todos.filter((todo) => todo.id !== action.payload);
        },
    },
});

export default todoSlice.reducer;
export const { addTodo, removeTodo } = todoSlice.actions;
