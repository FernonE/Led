"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var testing_1 = require("@angular/core/testing");
var app_service_1 = require("./app.service");
describe('AppService', function () {
    beforeEach(function () { return testing_1.TestBed.configureTestingModule({}); });
    it('should be created', function () {
        var service = testing_1.TestBed.get(app_service_1.AppService);
        expect(service).toBeTruthy();
    });
});
//# sourceMappingURL=app.service.spec.js.map