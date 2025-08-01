export const formatPrice = (amount) => {
    return new Intl.NumberFormat("en-IN", {
       style: "currency",
       currency: "INR",
    }).format(amount);
};


export const formatPriceCalculation = (quantity, price) => {
    return (Number(quantity) * Number(price)).toFixed(2);
};
