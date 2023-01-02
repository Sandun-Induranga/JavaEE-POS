/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

function loadAllOrders() {
    $("#tblOrders > tbody").empty();

    for (let order of ordersDB) {
        $("#tblOrders > tbody").append(
            `<tr><td>${order.orderId}</td><td>${order.customerId}</td><td>${order.customerName}</td><td>${order.date}</td><td>${order.total}</td><td>${order.discount}</td><td>${order.amount}</td><td><i class="bi bi-trash text-danger order-deletes"></i></td></tr>`
        );
    }
    bindOrdersDeleteEvent();
}