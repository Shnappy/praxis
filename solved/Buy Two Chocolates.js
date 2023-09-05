/**
 * @param {number[]} prices
 * @param {number} money
 * @return {number}
 */
//if can be removed completely using return leftOver >= 0 ? leftOver : money
var buyChoco = function(prices, money) {
    let sortedPrices = prices.sort((a,b)=>a-b);
    leftOver = money - sortedPrices.at(0) - sortedPrices.at(1);
    if(leftOver >= 0) {
        return leftOver;
    }
    else {
        return money;
    }
};
