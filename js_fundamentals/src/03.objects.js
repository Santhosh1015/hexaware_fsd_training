const product = {
    "id" : 1,
    "name" : "Oppo mobile A10",
    "price" : 20000,
    "category": "mobiles"
}

// clone of the product
// using spread op
//it will used for upack all elements from the array - objects
const prod = {...product}

product.price = product.price * 0.9

console.log(`id is ${product.id} and price is ${product.price}`);
console.log(`id is ${prod.id} and price is ${prod.price}`);

/*
id is 1 and price is 18000
id is 1 and price is 20000
*/