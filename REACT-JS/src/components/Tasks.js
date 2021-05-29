// Here is a Dummy task for us to work with
const tasks = [
    {
        id: 1,
        text: 'Go to School',
        day: 'May 30 2021 12 PM',
        reminder: true,
    },
    {
        id: 2,
        text: 'Search Breakfast',
        day: 'May 31 2021 7 AM',
        reminder: true,
    },
    {
        id: 3,
        text: 'Food Shopping',
        day: 'June 1 2021 5 PM',
        reminder: false,
    },

]

const Tasks = () => {
    return(
        // if we want to return multiple objects without parent, we can 
        // put it in empty tag
        // It is mandatory to give unique key prop if returning list
        <>
            { tasks.map( (task) => (<h4 key={task.id}>{task.text}</h4>))}
        </>
    );
}

export default Tasks