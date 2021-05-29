// Import proptype for define type of each prop to make app robust
import PropTypes from 'prop-types'
// While accepting Props, we can also destruct them 
// so that we know what is coming in props
const Button = ({color, text, onClick}) => {
    return (
        <button className='btn' 
            style={{ backgroundColor: color }}
            onClick={onClick}>
                {text}
        </button>
    );
}

// lets define Default props
Button.defaultProps = {
    color: 'steelblue'
}

// Types of each prop
Button.propTypes = {
    color: PropTypes.string,
    text: PropTypes.string,
    onClick: PropTypes.func
}

// lets define type of each prop
export default Button