
var sort = function () {
    var cont = 0
    while (1) {
        var number = Math.floor(Math.random() * 100)
        if (cont == 10) {
            console.log('Finished')
            break
        }
        if (number % 2 == 0) {
            console.log(`${number} is even`)
        } else {
            console.log(`${number} it's odd`)
        }

        cont += 1
    }
}

sort()