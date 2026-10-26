const Nums = () => {
    const nums = [1, 2, 3, 4, 5, 6]
    return (
        <div className="list-group">
            {nums.map((n, index) => (
                <a href="#" className="list-group-item list-group-item-action list-group-item-primary" key={index}><li >{n}</li></a>

            ))}
        </div>

    )
}

export default Nums