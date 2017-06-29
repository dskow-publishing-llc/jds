/**
 * searchResultsPageUtils JavaScript Library
 */
(function(window) {

  function handleEsearchresults() {
    // work around to keep grid from shrinking on page resize.
    var canvas = d3.select(".kgCanvas");
    var viewport = d3.select(".kgViewport");
  }
  window.onresize = handleEsearchresults;
  handleEsearchresults();
}(window));
