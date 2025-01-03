//Every Object in our form will have its own state for capturing values
import { useState } from 'react'

const AddTask = ({ onAdd }) => {

    // State for each element
    const [text, setText] = useState('')
    const [day, setDay] = useState('')
    const [reminder, setReminder] = useState(false)

    // We need to make prevent page submit and do some validation, so we need a custom function
    const saveTask = (e) => {
        // Prevent dafault page submit action
        e.preventDefault()

        // validate fields data
        if (!text || !day) {
            alert('Please enter task details')
            return
        }

        onAdd({ text, day, reminder });

        // Reset the form
        setText('');
        setDay('');
        setReminder(false);

    }

    return (
        <form className='add-form' onSubmit={saveTask}>
            <div className='form-control'>
                <label>Task</label>
                <input name='text'
                    type='text'
                    placeholder='Add Task'
                    value={text}
                    onChange={(e) => setText(e.target.value)} />
            </div>
            <div className='form-control'>
                <label>Day and Time</label>
                <input name='day'
                    type='text'
                    placeholder='Add Day and Time'
                    value={day}
                    onChange={(e) => setDay(e.target.value)} />
            </div>
            <div className='form-control form-control-check'>
                <label>Set Reminder</label>
                <input name='reminder'
                    type='checkbox'
                    value={reminder}
                    checked={reminder}
                    onChange={(e) => setReminder(e.currentTarget.checked)} />
            </div>
            <div className='form-control'>
                <input type='submit' value='Save Task' className='btn btn-block' />
            </div>
        </form>
    );
}

export default AddTask