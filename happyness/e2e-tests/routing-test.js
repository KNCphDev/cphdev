describe('Routing test', function() {

    it('should redirect index.html to index.html#/happiness', function () {
        browser.get('index.html');
        browser.getLocationAbsUrl().then(function (url) {
            expect(url.split('#')[1]).toBe('/happiness');
        });
    });

});
