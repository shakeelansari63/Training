// Import Header Object from components
import Header from './components/Header'
import Tasks from './components/Tasks'

// This is main app which is embedded in 
function App() {
  return (
    <div className="container">
      {/* This is JSX object and it does not support either JS or HTML comments
      Here comments are stored inside {} */}
      {/* <h1>Hello From React</h1> 
      Lets Put the Header tag to call Header object*/}
      <Header />

      {/** Display tasks */}
      <Tasks />
    </div>
  );
}

export default App;
