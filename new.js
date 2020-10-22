const mongoose = require("mongoose");

var userModel = new mongoose.Schema({
email:String,
password:String

})

module.exports = mongoose.model("User", userModel);