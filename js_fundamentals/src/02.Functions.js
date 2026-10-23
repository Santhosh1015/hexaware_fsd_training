// standrad Function

function addTax(amount){
    return amount*1.08
}

// arrow function
const addTax2 = amount => amount * 1.08



// give discount
// function bill(amount){
//     let discount = 10
//     amount = amount - ((amount * discount)/100)
//     return addTax2(amount)
// }



const discountPercent = 10
const discount = amount =>{
    amount = amount - ((amount * discountPercent)/100)
} 
const amount = 1000
const bill = amount => {
    amount = discount(amount)
    console.log(`The discounted Amount you got for your purchase ${amount}`);
    console.log(`The Final amount after compute Tax ${addTax2(amount)}`);
    
}
bill(amount)
// compute area od circle
const pi = 3.14

function areaCircle(radius){
    return pi * radius * radius
}

const areaCircle2 = radius => pi * radius * radius
// console.log(`The area of circle is ${areaCircle(5)}`)
// console.log(`The area of circle is ${areaCircle2(10)}`)

