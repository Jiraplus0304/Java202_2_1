const display = document.getElementById("display")
const handleNavbar = function () {
    const nav = document.getElementById('nav')
    nav.addEventListener("click", changComponent)
}
const changComponent = function (e = new Event('element')) {
    const select = e.target.getAttribute('id')
    switch (select) {
        case "product-list":
            loadProductListPage()
            break
        default:
            console.log("homepage")
            break
    }
}


const loadProductListPage = async function () {
    const request = await fetch('./product-list.jsp')
    const html = await request.text()
    display.innerHTML = html;
    await loadListProduct()
}
const loadProductDetail = async function (productCode) {
    const productDetail = document.getElementById("product-detail")
    const request = await fetch(`selected-product?code=${productCode}`)
    const html = await request.text();
    productDetail.innerHTML = html;
    await loadListProduct()
}

const loadListProduct = async function () {
    const productsArea = document.getElementById("products-area")
    const request = await fetch('product-list')
    const html = await request.text();
    productsArea.innerHTML = html;
}


const init = function () {
    handleNavbar();
}

init();