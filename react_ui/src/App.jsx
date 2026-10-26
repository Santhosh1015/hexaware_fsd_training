const App = () => {
  const nums = [1,2,3,4,5,6]
  return(
    <div>
      <h1>My react App</h1>
      <p>The full Nums array : {nums}</p>
      <hr />
      {nums.map((n, index)=>(
        <li key={index}>{n}</li>
      ))}
    </div>
  )
}
  
export default App