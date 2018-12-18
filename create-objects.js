// Normally we would let Mongo generate IDs with its own ObjectID type,
// but we want this Collection to be compatible with the Customer entity,
// which is using a long as its ID type, so we specify the IDs as longs.
db.customer.insertMany([
    { _id: 1, name: "Joe Smith" , age: 55},
    { _id: 2, name: "Jane Jones" , age: 25},
    { _id: 3, name: "Alex Brown" , age: 15},
    { _id: 4, name: "George Lee" , age: 30}
]);
