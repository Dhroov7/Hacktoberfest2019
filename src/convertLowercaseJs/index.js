var text = 'Hello Hacktoberfest'

var result = text.split('').map(function(c){
  return c === c.toUpperCase()
  ? c.toLowerCase()
  : c.toUpperCase()
}).join('')

console.log(result)