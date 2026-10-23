const products = [
  {
    "id": 1,
    "name": "Oppo mobile A10",
    "price": 20000,
    "category": "mobiles"
  },
  {
    "id": 2,
    "name": "Samsung Galaxy M14",
    "price": 14999,
    "category": "mobiles"
  },
  {
    "id": 3,
    "name": "Redmi Note 12",
    "price": 16999,
    "category": "mobiles"
  },
  {
    "id": 4,
    "name": "Realme Narzo 60",
    "price": 17999,
    "category": "mobiles"
  },
  {
    "id": 5,
    "name": "Vivo T2x",
    "price": 12999,
    "category": "mobiles"
  },
  {
    "id": 6,
    "name": "OnePlus Nord CE 3 Lite",
    "price": 19999,
    "category": "mobiles"
  },
  {
    "id": 7,
    "name": "PCO X5 Pro",
    "price": 22999,
    "category": "mobiles"
  },
  {
    "id": 8,
    "name": "Moto G54",
    "price": 13999,
    "category": "mobiles"
  },
  {
    "id": 9,
    "name": "iQOO Z7s",
    "price": 18999,
    "category": "mobiles"
  },
  {
    "id": 10,
    "name": "Infinix Zero 30",
    "price": 21999,
    "category": "mobiles"
  }
]

// use for each method to iterate over

// products.forEach(p=> console.log(p))

// cloning the array

const prods = [...products]// whole array is cloned

// search opreation 

let id = 4
//objecct in js return Undefined
let prod = prods.find(p=> p.id === id)

console.log((prod == undefined) ? `Product wit ${id} does not exists` : "The product is", prod);
// `The product is  ${prod}` => The product is  [object Object]
// "The product is", prod  => The product is { id: 4, name: 'Realme Narzo 60', price: 17999, category: 'mobiles' }

console.log("---------------filter op ------------------");

let filteredArray = prods.filter(p=>p.price >= 30000)

filteredArray.length > 0 ? filteredArray.forEach(p=> console.log(p)):
console.log("No matching Found..");

console.log("---------------Map op ------------------")
// map the products to get the names of the products
let productNames = prods.map(p=>p.name).forEach(p=>console.log(`Product Name : ${p}`))


console.log("--------------Reduce op ------------------")
let totalPrice = prods.reduce((sum,p)=>(sum+p.price),0)
console.log(`Total Price : ${totalPrice}`);

