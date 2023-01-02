/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

class Customer{
    #cusId;
    #cusName;
    #cusAddress;
    #cusSalary;

    constructor(cusId, cusName, cusAddress, cusSalary) {
        this.#cusId = cusId;
        this.#cusName = cusName;
        this.#cusAddress = cusAddress;
        this.#cusSalary = cusSalary;
        this._cusId = cusId;
        this._cusName = cusName;
        this._cusAddress = cusAddress;
        this._cusSalary = cusSalary;
    }

    get cusId() {
        return this._cusId;
    }

    set cusId(value) {
        this._cusId = value;
    }

    get cusName() {
        return this._cusName;
    }

    set cusName(value) {
        this._cusName = value;
    }

    get cusAddress() {
        return this._cusAddress;
    }

    set cusAddress(value) {
        this._cusAddress = value;
    }

    get cusSalary() {
        return this._cusSalary;
    }

    set cusSalary(value) {
        this._cusSalary = value;
    }

}
