import { useState } from "react";
const Nums = () => {
    const nums = [1, 2, 3, 4, 5, 6] // normal variable

    const [numsArray, setNumsArray] = useState([1,3,4,7,4,9,6]) // state variable . it'll render when state changes
    const [numsClone] = useState([...numsArray])
    const sortFn = (direction) => {
        switch (direction) {
            case 'ASC' :
                setNumsArray([...numsArray.sort((a,b)=>a-b)])
                break;
            case 'DESC':
                setNumsArray([...numsArray.sort((a,b)=>b-a)])
                break;
            default:
                setNumsArray([...numsClone])
                break;
        }
    }

    return (
        <div className="list-group">
            {numsArray.map((n, index) => (
                <a href="#" className="list-group-item list-group-item-action list-group-item-primary" key={index}><li >{n}</li></a>
            ))}
            &nbsp; &nbsp;
            <div>
                <button className="btn btn-primary" onClick={()=>sortFn('ASC')}> Sort-Asc</button>&nbsp; &nbsp;
                <button className="btn btn-primary" onClick={ ()=>sortFn('')}> RESET</button>&nbsp; &nbsp;
                <button className="btn btn-primary" onClick={ ()=>sortFn('DESC')}> Sort-DESC</button>

            </div>
             &nbsp; &nbsp;
        </div>

    )
}
export default Nums