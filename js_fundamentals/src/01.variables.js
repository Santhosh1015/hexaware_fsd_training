// can't be re- assigned
const storeName = "My Awesome Store"

console.log(typeof storeName)

// can be - but usually within function
let visitors = 0
console.log(typeof visitors)

visitors = visitors +10
console.log(`Vistiors at ${visitors}`)

output = `The ${storeName} has ${visitors} visitors`

console.log(output);
