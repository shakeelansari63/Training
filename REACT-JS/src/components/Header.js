//This is Header object 
// Header objects can either have class of function, we will use fuction

import Button from "./Button"

// Js objects can accept parameters in form of props. 
// For example we can define title='XYZ' in Appjs for Header like 
// <Header title='hello World'/>, to in order to catch the title, use props
const Header = (props) => {

    const clickButton = () => {
        console.log('Button Clicked !!!')
    }

    // return JSX Object
    return (
        <>
            <div className='container' style={{ backgroundColor: 'red', color: 'white' }} >
                <h1>React Crash Course</h1>
            </div>
            <header className='header'>
                <h1>{props.title}</h1>
                {/** Instead of using button we can have re-usable button component
                 * And We can pass props to customise them
                 * <button className='btn'>Add</button>
                 */}
                <Button color='green' text='Add' onClick={clickButton} />
            </header>
        </>
    );
}

// But if prop is not pssed in, we can have default props to use
Header.defaultProps = {
    title: 'Task Tracker'
}

// We can also have dynamic styling for every object
// const headerStyle = {
//     color: 'red',
//     backgroundColor: 'black'
// }

export default Header