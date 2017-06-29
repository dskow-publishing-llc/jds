/*******************************************************************************
 * koReport JavaScript Library Authors:
 * https://github.com/davidskowronski/koReport/blob/master/README.md License:
 * MIT (http://www.opensource.org/licenses/mit-license.php) Compiled At:
 * 12/19/2012 10:15:47
 ******************************************************************************/
/* jshint multistr: true */
/* jshint bitwise: false */
(function(window) {
    'use strict';
    if (!window.kr) {
        window.kr = {};
    }
    window.kr.numberOfReports = 0;
    window.kr.eventStorage = {};
    var SELECTED_PROP = '__kr_selected__', REPORT_KEY = '__koReport__', EXCESS_SECTION = 41, SCROLL_THRESHOLD = 6, ASC = "asc", DESC = "desc", KR_FIELD = '_kr_field_', KR_DEPTH = '_kr_depth_', KR_HIDDEN = '_kr_hidden_', KR_SECTION_PART = '_kr_sectionPart_', TEMPLATE_REGEXP = /<.+>/;
    if (!String.prototype.trim) {
        String.prototype.trim = function() {
            return this.replace (/^\s+|\s+$/g, '');
        };
    }
    if (!Array.prototype.indexOf) {
        Array.prototype.indexOf = function(elt) {
            var len = this.length >>> 0; // convert any type to a positive
            // integer
            var from = Number (arguments[1]) || 0;
            from = (from < 0) ? Math.ceil (from) : Math.floor (from);
            if (from < 0) {
                from += len;
            }
            for (; from < len; from++) {
                if (from in this && this[from] === elt) {
                    return from;
                }
            }
            return -1;
        };
    }
    window.kr.utils = {
        visualLength : function(node) {
            var elem = document.getElementById ('testDataLength');
            if (!elem) {
                elem = document.createElement ('SPAN');
                elem.id = "testDataLength";
                elem.style.visibility = "hidden";
                document.body.appendChild (elem);
            }
            $ (elem).css ('font', $ (node).css ('font'));
            elem.innerHTML = $ (node).text ();
            return elem.offsetWidth;
        },
        forIn : function(obj, action) {
            for ( var prop in obj) {
                if (obj.hasOwnProperty (prop)) {
                    action (obj[prop], prop);
                }
            }
        },
        evalProperty : function(entity, path) {
            var e = window.ko.utils.unwrapObservable (entity);
            var propPath = path.split ('.'), i = 0;
            var tempProp = window.ko.utils.unwrapObservable (e[propPath[i]]), links = propPath.length;
            i++;
            while (tempProp && i < links) {
                tempProp = window.ko.utils
                        .unwrapObservable (tempProp[propPath[i]]);
                i++;
            }
            return tempProp;
        },
        endsWith : function(str, suffix) {
            if (!str || !suffix || typeof str !== "string") {
                return false;
            }
            return str.indexOf (suffix, str.length - suffix.length) !== -1;
        },
        isNullOrUndefined : function(obj) {
            if (obj === undefined || obj === null) {
                return true;
            }
            return false;
        },
        getElementsByClassName : function(cl) {
            var retnode = [];
            var myclass = new RegExp ('\\b' + cl + '\\b');
            var elem = document.getElementsByTagName ('*');
            for (var i = 0; i < elem.length; i++) {
                var classes = elem[i].className;
                if (myclass.test (classes)) {
                    retnode.push (elem[i]);
                }
            }
            return retnode;
        },
        getTemplatePromise : function(path) {
            return $.ajax (path);
        },
        newId : (function() {
            var seedId = new Date ().getTime ();
            return function() {
                return seedId += 1;
            };
        }) (),
        ieVersion : (function() {
            var version = 3, div = document.createElement ('div'), iElems = div
                    .getElementsByTagName ('i');
            while (div.innerHTML = '<!--[if gt IE ' + (++version) +
                    ']><i></i><![endif]-->', iElems[0])
                ;
            return version > 4 ? version : undefined;
        }) (),
        graph : function(options) {

            var color = options.color, graphId = options.graphId, graphdata = options.graphdata, xLabel = options.xLabel, yLabel = options.yLabel, canvaswidth = options.canvaswidth, canvasheight = options.canvasheight, graphType = options.graphType, xLabelFormat = options.xLabelFormat, yLabelFormat = options.yLabelFormat;

            var xAxisLabel = typeof xLabel === undefined ? " " : xLabel;
            var yAxisLabel = typeof yLabel === undefined ? " " : yLabel;

            color.domain (window.d3.keys (graphdata[0]).filter (function(key) {
                return key !== "time";
            }));
            var gData = color.domain ().map (function(obj) {
                var labelName = "";
                return {
                    obj : obj,
                    values : graphdata.map (function(d) {
                        labelName = d[obj].label;
                        return {
                            obj : d[obj].label,
                            time : d.time,
                            score : +d[obj].value,
                            name : labelName
                        };
                    }),
                    names : labelName
                };
            });
            var lNames = [];
            gData.forEach (function(item) {
                lNames.push (item.names);
            });
            var max = window.d3.max (lNames) || 10;
            var margin = {
                top : 30,
                right : canvaswidth * 0.25,
                bottom : 40,
                left : 60
            }, width = canvaswidth - margin.left - margin.right, height = canvasheight -
                    margin.top - margin.bottom;
            var x = window.d3.time.scale ().range ([ 0, width ]);
            var y = window.d3.scale.linear ().range ([ height, 0 ]);
            var yformat = (yLabelFormat !== undefined) ? yLabelFormat : "$";
            var xformat = (xLabelFormat !== undefined) ? xLabelFormat : "y";
            var xAxis = window.d3.svg.axis ().scale (x).orient ("bottom")
                    .ticks (5).tickFormat (window.d3.format (xformat));
            var yAxis = window.d3.svg.axis ().scale (y).tickFormat (
                    window.d3.format (yformat)).orient ("left").ticks (5);
            var valueline = window.d3.svg.line ().defined (function(d) {
                return !isNaN (d.score);
            }).x (function(d) {
                return x (d.time);
            }).y (function(d) {
                return y (d.score);
            });
            var svg = window.d3.select (graphId).append ("svg").attr ("width",
                    width + margin.left + margin.right + 40).attr ("height",
                    height + margin.top + margin.bottom).style (
                    "background-color", "#D9D9D9").append ("g").attr (
                    "transform",
                    "translate(" + margin.left + "," + margin.top + ")");
            svg.append ("text").attr (
                    "transform",
                    "translate(" + (width / 2) + " ," +
                            (height + margin.bottom) + ")").style (
                    "text-anchor", "middle").text (xAxisLabel);
            svg.append ("text").attr ("transform", "rotate(-90)").attr ("y",
                    0 - margin.left).attr ("x", 0 - (height / 2)).attr ("dy",
                    "1em").style ("text-anchor", "middle").text (yAxisLabel);
            x.domain (window.d3.extent (graphdata, function(d) {
                return d.time;
            }));
            y.domain ([ 0, window.d3.max (gData, function(c) {
                return window.d3.max (c.values, function(v) {
                    return v.score;
                });
            }) ]);
            var legend = svg.selectAll ('g').data (gData).enter ().append ('g')
                    .attr ('class', 'legend');
            legend.append ('text').attr ('x', width + margin.right / 2).attr (
                    'y', 9).text ("Legend").attr ("text-decoration",
                    "underline");
            legend.append ('rect').attr ('x', width + width / 12 + 5).attr (
                    'y', function(d, i) {
                        return i * 20 + 20;
                    }).attr ('width', 10).attr ('height', 10).style ('fill',
                    function(d) {
                        return color (d.obj);
                    });
            legend.append ('text').attr ('x', width + width / 12 + 20).attr (
                    'y', function(d, i) {
                        return (i * 20) + 30;
                    })
                    .style ('font-size', 3 + margin.right / max.length + 'px')
                    .text (function(d, i) {
                        return d.names;
                    });
            if (graphType === "line") {
                var series = svg.selectAll (".series").data (gData).enter ()
                        .append ("g").attr ("class", "series");
                series.append ("path").attr ("class", "line").attr ("d",
                        function(d, i) {
                            return valueline (d.values);
                        }).style ("stroke", function(d) {
                    return color (d.obj);
                });
                var point = series.append ("g").attr ("class", "line-point");
                point.selectAll ("circle").data (function(d) {
                    return d.values;
                }).enter ().append ("circle").attr ("cx", function(d) {
                    return !isNaN (d.score) ? x (d.time) : width;
                }).attr ("cy", function(d) {
                    return !isNaN (d.score) ? y (d.score) : height;
                }).attr ("r", 3).style ("stroke", function(d) {
                    return !isNaN (d.score) ? color (d.obj) : "white";
                }).attr ("fill", "white").append ("svg:title").text (
                        function(d) {
                            return d.score % 1 === 0 ? d.score : d.score
                                    .toFixed (2);
                        });
            }
            if (graphType === "bar") {
                svg.selectAll (".series").data (graphdata).enter ().append (
                        "svg:rect").attr ("class", "series").attr ("y",
                        function(d) {
                            return y (d.x.value);
                        }).attr ("x", function(d, i) {
                    return i === 0 ? x (d.time) : x (d.time) - 10;
                }).attr ("width", 20).attr ("height", function(d) {
                    return height - y (d.x.value);
                }).style ("fill", "steelblue").append ("svg:title").html (
                        function(d) {
                            return "Year: " +
                                    d.time +
                                    " Value:" +
                                    (d.x.value % 1 === 0 ? d.x.value
                                            : d.x.value.toFixed (2)) +
                                    " Label: " + d.x.label;
                        });
            }
            svg.append ("g").attr ("class", "x axis").attr ("transform",
                    "translate(0," + height + ")").call (xAxis);
            svg.append ("g").attr ("class", "y axis").call (yAxis);
        }
    };
    window.$.extend (window.kr.utils, {
        isIe6 : (function() {
            return window.kr.utils.ieVersion === 6;
        }) (),
        isIe7 : (function() {
            return window.kr.utils.ieVersion === 7;
        }) (),
        isIe : (function() {
            return window.kr.utils.ieVersion !== undefined;
        }) ()
    });
    /* jshint multistr: true */
    var defaultReportTemplateStr = '\
        <div data-bind="css: {\'ui-widget\': jqueryUITheme, \'krNoSelect\' : disableTextSelection}">\
        <div class="krViewport" data-bind="css: {\'ui-widget-content\': jqueryUITheme}">\
          <div class="krCanvas">\
            <div data-bind="attr: {\'class\' : reportNameClass }">\
              <span data-bind="html: reportName"></span>\
              <button class="graphbtn" data-bind="visible: showRdfLink, click: opengraph"><img class="rdfIcon" src="/images/rdf.png"></img></button>\
              <!-- <span style="float: right;" data-bind="attr: {\'class\' : menuClass }"></span> -->\
            </div>\
            <div data-bind="with: renderedHeader">\
              <div data-bind="style: { \'top\': \'0px\'}, krHeader: $data" class=krHeader></div>\
            </div>\
            <div data-bind="foreach: renderedSections">\
              <div data-bind="krSection: $data" class="krSection"></div>\
            </div>\
          </div>\
        </div>\
      </div>', defaultHeaderTemplateStr = '\
        <div class="container"">\
        <div>\
          <span data-bind="attr: {\'class\' : titleClass }, html: $data.value"></span>\
        </div>\
        <div data-bind="visible: showDoc" style="float:right">\
          <div>Information Sources</div>\
          <button class="docbtn" data-bind="attr: {\'onclick\' : doclink}, html : docname"></button>\
        </div>\
        <div data-bind="foreach: headerParts">\
          <div>\
            <span class="headerTagClass" data-bind="text: tag">: </span>\
            <span class="headerValueClass" data-bind="text: value"></span>\
          </div>\
        </div>\
        <div data-bind="visible: showChart">\
          <div class="centerdiv" id="graph-2"></div>\
        </div>\
      </div>\
      ', defaultSectionTemplateStr = '\
      <div class="row container" data-bind="attr: {\'class\' : sectionClass }">\
        <div class="header" data-bind="click: toggleExpand">\
          <div class="h3Class">\
            <span data-bind="html: sectionName()"></span>\
              <!-- <span data-bind="attr: {\'class\' : infoIconClass }"></span>\
              <span data-bind="attr: {\'class\' : warningIconClass }"></span> -->\
              <span style="float: right"><span data-bind="attr: {\'class\' : openCloseGlyphIconClass }"></span></span>\
          </div>\
        </div>\
        <div data-bind="attr: {\'class\' : summaryClass }">\
          <div data-bind="foreach: summarySectionParts">\
            <div>\
              <span class="summaryTagClass" data-bind="text: tag"></span>\
              <span class="summaryValueClass" data-bind="text: value"></span>\
            </div>\
          </div>\
        </div>\
        <div data-bind="attr: {\'class\' : detailsClass }">\
          <div data-bind="foreach: detailsSectionParts">\
            <div>\
              <span class="detailsTagClass" data-bind="text: tag">: </span>\
              <span class="detailsValueClass" data-bind="text: value"></span>\
            </div>\
          </div>\
          <div data-bind="visible: showLink">\
            <button class="reportbtn" data-bind="click: opendoc, html : docname"></button>\
          </div>\
        </div>\
      </div>\
    ';
    window.kr.defaultReportTemplate = function() {
        return defaultReportTemplateStr;
    };
    window.kr.defaultHeaderTemplate = function() {
        return defaultHeaderTemplateStr;
    };
    window.kr.defaultSectionTemplate = function() {
        return defaultSectionTemplateStr;
    };

    window.ko.bindingHandlers.koReport = (function() {
        return {
            'init' : function(element, valueAccessor, allBindingsAccessor,
                    viewModel, bindingContext) {
                var options = valueAccessor ();
                var dataUnwrapped = window.ko.unwrap (options.data ());
                var elem = $ (element);
                options.reportDim = new window.kr.Dimension ({
                    outerHeight : window.ko.observable (elem.height ())
                });
                var report = new window.kr.Report (options);
                var reportElem = $ (window.kr.defaultReportTemplate ());
                options.data.subscribe (function() {
                    if (report.$$selectionPhase) {
                        return;
                    }
                    if (report.myData.peek ().sections !== undefined) {
                        setTimeout (function() {
                            report.headerFactory.myDataChanged ();
                        }, 100);
                    }
                    report.refreshDomSizes ();
                });
                if (window.ko.isObservable (options.sectionPartDefs)) {
                    options.sectionPartDefs.subscribe (function(newDefs) {
                        report.sectionParts ([]);
                        report.config.sectionPartDefs = newDefs;
                        report.buildSectionParts ();
                    });
                }
                elem.addClass ("koReport").addClass (
                        report.reportId.toString ());
                elem.append (reportElem);
                report.$userViewModel = bindingContext.$data;
                window.ko.applyBindings (report, reportElem[0]);
                window.kr.domUtilityService.AssignReportContainers (elem,
                        report);
                report.refreshDomSizes ();
                report.eventProvider = new window.kr.EventProvider (report);
                $.each (report.config.plugins, function(i, p) {
                    if (typeof p.onReportInit === 'function') {
                        p.onReportInit (report);
                    }
                });
                window.ko.virtualElements.allowedBindings.stopBinding = true;
                return {
                    controlsDescendantBindings : true
                };
            }
        };
    } ());
    window.ko.bindingHandlers.krSection = {
        'init' : function(element, valueAccessor, allBindingsAccessor,
                viewModel, bindingContext) {
            var section = valueAccessor ();
            var report = section.$report = bindingContext.$parent;
            var source = report.sectionTemplate;
            var compile = function(html) {
                var sectionElem = $ (html);
                section.$userViewModel = bindingContext.$parent.$userViewModel;
                window.ko.applyBindings (section, sectionElem[0]);
                $ (element).html (sectionElem);
            };
            if (source.then) {
                source.then (function(p) {
                    compile (p);
                });
            } else {
                compile (source);
            }
            return {
                controlsDescendantBindings : true
            };
        }
    };
    window.ko.bindingHandlers.krHeader = {
        'init' : function(element, valueAccessor, allBindingsAccessor,
                viewModel, bindingContext) {
            var header = valueAccessor ();
            var report = header.$report = bindingContext.$parent;
            var source = report.headerTemplate;
            var compile = function(html) {
                var headerElem = $ (html);
                header.$userViewModel = bindingContext.$parent.$userViewModel;
                window.ko.applyBindings (header, headerElem[0]);
                $ (element).html (headerElem);
            };
            if (source.then) {
                source.then (function(p) {
                    compile (p);
                });
            } else {
                compile (source);
            }
            return {
                controlsDescendantBindings : true
            };
        }
    };
    window.ko.bindingHandlers.krHeaderCell = {
        'init' : function(element, valueAccessor, allBindingsAccessor,
                viewModel, bindingContext) {
            var newContext = bindingContext.extend ({
                $report : bindingContext.$parent,
                $userViewModel : bindingContext.$parent.$userViewModel
            });
            var compile = function(html) {
                var headerCell = $ (html);
                window.ko.applyBindings (newContext, headerCell[0]);
                $ (element).html (headerCell);
            };
            return {
                controlsDescendantBindings : true
            };
        }
    };
    window.kr.Dimension = function(options) {
        this.outerHeight = null;
        $.extend (this, options);
    };
    window.kr.EventProvider = function(report) {
        var self = this;
        self.colToMove = undefined;
        self.groupToMove = undefined;
        self.assignEvents = function() {
        };
        self.assignReportEventHandlers = function() {
            report.$viewport
                    .scroll (function(e) {
                        var scrollLeft = e.target.scrollLeft, scrollTop = e.target.scrollTop;
                        report.adjustScrollLeft (scrollLeft);
                        report.adjustScrollTop (scrollTop);
                    });
            if (report.config.tabIndex === -1) {
                report.$viewport.attr ('tabIndex', window.kr.numberOfReports);
                window.kr.numberOfReports++;
            } else {
                report.$viewport.attr ('tabIndex', report.config.tabIndex);
            }
            $ (window).resize (function() {
                window.kr.domUtilityService.UpdateReportLayout (report);
            });
        };
        self.assignReportEventHandlers ();
        self.assignEvents ();
    };
    window.kr.HeaderFactory = function(report) {
        var self = this;
        self.headerCache = [];
        self.parentCache = [];
        self.dataChanged = true;
        self.parsedData = [];
        self.headerConfig = {};
        self.headerHeight = 350;
        self.groupedData = undefined;
        self.headerHeight = report.config.headerHeight;
        self.headerConfig = {
            canSelectHeaders : report.config.canSelectHeaders,
            headerClasses : report.config.headerClasses,
            selectedItems : report.config.selectedItems,
            beforeSelectionChangeCallback : report.config.beforeSelectionChange,
            afterSelectionChangeCallback : report.config.afterSelectionChange
        };
        self.renderedRange = new window.kr.Range (0, report
                .minHeadersToRender () +
                EXCESS_SECTION);
        self.buildEntityHeader = function(entity) {
            var header = self.headerCache[0];
            if (!header) {
                header = new window.kr.Header (entity);
                self.headerCache[0] = header;
            }
            return header;
        };
        self.UpdateViewableRange = function(newRange) {
            self.renderedRange = newRange;
            self.renderedChange ();
        };
        self.myDataChanged = function() {
            self.dataChanged = true;
            self.headerCache = [];
            self.UpdateViewableRange (self.renderedRange);
        };
        self.renderedChange = function() {
            self.renderedChangeNoGroups ();
            report.refreshDomSizes ();
        };
        self.renderedChangeNoGroups = function() {
            var headerArr = [];
            var dataArr = report.myData ().header;
            var section = self.buildEntityHeader (dataArr,
                    self.renderedRange.topSection);
            headerArr.push (section);
            report.setRenderedHeader (headerArr[0]);
        };
        self.parseGroupData = function(g) {
            if (g.values) {
                $.each (g.values, function(i, item) {
                    self.parentCache[self.parentCache.length - 1].children
                            .push (item);
                    self.parsedData.push (item);
                });
            } else {
                for ( var prop in g) {
                    if (prop === KR_FIELD || prop === KR_DEPTH ||
                            prop === KR_SECTION_PART) {
                        continue;
                    } else if (g.hasOwnProperty (prop)) {
                        self.parseGroupData (g[prop]);
                    }
                }
            }
        };
        self.getGrouping = function(groups) {
            self.headerCache = [];
            self.groupedData = {};
            var data = report.myData ().sections;
            var maxDepth = groups.length;
            var cols = report.sectionParts ();
            $.each (data, function(i, item) {
                item[KR_HIDDEN] = true;
                var ptr = self.groupedData;
                $.each (groups, function(depth, group) {
                    var col = cols[0];
                    var val = window.kr.utils.evalProperty (item, group);
                    val = val ? val.toString () : 'null';
                    if (!ptr[val]) {
                        ptr[val] = {};
                    }
                    if (!ptr[KR_FIELD]) {
                        ptr[KR_FIELD] = group;
                    }
                    if (!ptr[KR_DEPTH]) {
                        ptr[KR_DEPTH] = depth;
                    }
                    if (!ptr[KR_SECTION_PART]) {
                        ptr[KR_SECTION_PART] = col;
                    }
                    ptr = ptr[val];
                });
                if (!ptr.values) {
                    ptr.values = [];
                }
                ptr.values.push (item);
            });
            report.fixHeaderPartIndexes ();
            self.parsedData.length = 0;
            self.parseGroupData (self.groupedData);
        };
        if (report.config.groups.length > 0 &&
                report.myData ().sections.length > 0) {
            self.getGrouping (report.config.groups);
        }
    };
    window.kr.SectionFactory = function(report) {
        var self = this;
        self.chart1OnlyOnce = 0;
        self.sectionCache = [];
        self.parentCache = [];
        self.dataChanged = true;
        self.parsedData = [];
        self.sectionConfig = {};
        self.sectionHeight = 150;
        self.groupedData = undefined;
        self.sectionHeight = report.config.sectionHeight;
        self.sectionConfig = {
            canSelectSections : report.config.canSelectSections,
            sectionClasses : report.config.sectionClasses,
            selectedItems : report.config.selectedItems,
            beforeSelectionChangeCallback : report.config.beforeSelectionChange,
            afterSelectionChangeCallback : report.config.afterSelectionChange
        };
        self.renderedRange = new window.kr.Range (0, report
                .minSectionsToRender () +
                EXCESS_SECTION);
        self.buildEntitySection = function(entity, sectionIndex) {
            var section = self.sectionCache[sectionIndex];
            if (!section) {
                section = new window.kr.Section (entity, self);
                section.sectionIndex (sectionIndex + 1);
                section.offsetTop ((self.sectionHeight * sectionIndex)
                        .toString () +
                        'px');
                self.sectionCache[sectionIndex] = section;
            }
            return section;
        };
        self.UpdateViewableRange = function(newRange) {
            self.renderedRange = newRange;
            self.renderedChange ();
        };
        self.renderedChange = function() {
            self.renderedChangeNoGroups ();
            report.refreshDomSizes ();
        };
        self.renderedChangeNoGroups = function() {
            var sectionArr = [];
            if (report.myData () !== undefined &&
                    report.myData ().sections !== undefined) {
                var dataArr = report.myData ().sections.slice (
                        self.renderedRange.topSection,
                        self.renderedRange.bottomSection);
                var skipIndexCount = 0;
                $.each (dataArr, function(i, item) {
                    if (item.sectionName !== undefined) {
                        var section = self.buildEntitySection (item,
                                self.renderedRange.topSection + i -
                                        skipIndexCount);
                        sectionArr.push (section);
                    } else {
                        skipIndexCount = skipIndexCount + 1;
                    }
                });
            }
            report.setRenderedSections (sectionArr);
        };
        self.parseGroupData = function(g) {
            if (g.values) {
                $.each (g.values, function(i, item) {
                    self.parentCache[self.parentCache.length - 1].children
                            .push (item);
                    self.parsedData.push (item);
                });
            } else {
                for ( var prop in g) {
                    if (prop === KR_FIELD || prop === KR_DEPTH ||
                            prop === KR_SECTION_PART) {
                        continue;
                    } else if (g.hasOwnProperty (prop)) {
                        self.parseGroupData (g[prop]);
                    }
                }
            }
        };
        self.getGrouping = function(groups) {
            self.sectionCache = [];
            self.groupedData = {};
            var data = report.myData ().sections;
            var maxDepth = groups.length;
            var cols = report.sectionParts ();
            $.each (data, function(i, item) {
                item[KR_HIDDEN] = true;
                var ptr = self.groupedData;
                $.each (groups, function(depth, group) {
                    var col = cols[0];
                    var val = window.kr.utils.evalProperty (item, group);
                    val = val ? val.toString () : 'null';
                    if (!ptr[val]) {
                        ptr[val] = {};
                    }
                    if (!ptr[KR_FIELD]) {
                        ptr[KR_FIELD] = group;
                    }
                    if (!ptr[KR_DEPTH]) {
                        ptr[KR_DEPTH] = depth;
                    }
                    if (!ptr[KR_SECTION_PART]) {
                        ptr[KR_SECTION_PART] = col;
                    }
                    ptr = ptr[val];
                });
                if (!ptr.values) {
                    ptr.values = [];
                }
                ptr.values.push (item);
            });
            report.fixSectionPartIndexes ();
            self.parsedData.length = 0;
            self.parseGroupData (self.groupedData);
        };
        if (report.config.groups.length > 0 && report.myData ().length > 0) {
            self.getGrouping (report.config.groups);
        }
    };
    window.kr.Report = function(options) {
        var defaults = {
            sectionHeight : 70,
            headerHeight : 500,
            canSelectSections : true,
            selectAllState : window.ko.observable (false),
            data : window.ko.observableArray ([]),
            sectionPartDefs : undefined,
            selectedItems : window.ko.observableArray ([]),
            sortInfo : window.ko.observable (undefined),
            multiSelect : true,
            tabIndex : -1,
            enableSectionPartResize : true,
            maintainSectionPartRatios : undefined,
            beforeSelectionChange : function() {
                return true;
            },
            afterSelectionChange : function() {
            },
            sectionPartsChanged : function() {
            },
            headerPartsChanged : function() {
            },
            sectionTemplate : undefined,
            headerTemplate : undefined,
            jqueryUITheme : false,
            plugins : [],
            keepLastSelected : true,
            groups : [],
            enableSectionReordering : false,
            showSectionPartMenu : true,
            disableTextSelection : false,
            enablePaging : false,
            pagingOptions : {
                pageSizes : window.ko.observableArray ([ 250, 500, 1000 ]),
                pageSize : window.ko.observable (250),
                totalServerItems : window.ko.observable (0),
                currentPage : window.ko.observable (1)
            }
        }, self = this;
        self.maxCanvasHt = window.ko.observable (0);
        self.config = $.extend (defaults, options);
        self.config.sectionPartDefs = window.ko.utils
                .unwrapObservable (options.sectionPartDefs);
        self.reportId = "ng" + window.kr.utils.newId ();
        self.$root = null;
        self.parsedData = [];
        self.$topPanel = null;
        self.$headerContainer = null;
        self.$headerScroller = null;
        self.$headers = null;
        self.$viewport = null;
        self.$canvas = null;
        self.rootDim = self.config.reportDim;
        self.sortInfo = window.ko.isObservable (self.config.sortInfo) ? self.config.sortInfo
                : window.ko.observable (self.config.sortInfo);
        self.myData = self.config.data;
        self.lateBindSectionParts = false;
        self.lastSortedSectionPart = undefined;
        self.disableTextSelection = window.ko
                .observable (self.config.disableTextSelection);
        self.calcMaxCanvasHeight = function() {
            return (self.configGroups ().length > 0) ? (self.sectionFactory.parsedData.length * self.config.sectionHeight)
                    : (0 * self.config.sectionHeight);
        };
        self.elementDims = {
            scrollW : 0,
            scrollH : 0,
            sectionIndexCellW : 25,
            sectionSelectedCellW : 25,
            rootMaxW : 0,
            rootMaxH : 0
        };
        self.reportNameClass = window.ko.computed (function() {
            return "krReportName";
        });
        self.menuClass = window.ko.computed (function() {
            return "glyphicon glyphicon-list";
        });
        self.reportName = window.ko.computed (function() {
            return (self.myData () !== undefined) ? self.myData ().reportName
                    : "";
        });
        self.reportName = window.ko.computed (function() {
            return (self.myData () !== undefined) ? self.myData ().reportName
                    : "";
        });
        var opengraphdefaultfunc = function() {
        };
        self.opengraph = function() {
            if (self.myData ().opengraph !== undefined) {
                self.myData ().opengraph ();
            } else {
                opengraphdefaultfunc ();
            }
        };
        self.showRdfLink = window.ko.computed (function() {
            return true;
        });
        self.setRenderedHeader = function(newHeader) {
            self.renderedHeader (newHeader);
            self.refreshDomSizes ();
        };
        self.setRenderedSections = function(newSections) {
            self.renderedSections (newSections);
            self.refreshDomSizes ();
        };
        self.refreshDomSizes = function() {
            self.rootDim.outerHeight (self.elementDims.rootMaxH);
            self.maxCanvasHt (self.calcMaxCanvasHeight ());
        };
        self.buildSectionPartDefsFromData = function() {
            var sd = self.myData ();
            if (!self.config.sectionPartDefs) {
                self.config.sectionPartDefs = [];
            }
            if (!sd || !sd[0]) {
                self.lateBoundSectionParts = true;
                return;
            }
            var item;
            item = sd[0];
            window.kr.utils.forIn (item, function(prop, propName) {
                if (propName !== SELECTED_PROP) {
                    self.config.sectionPartDefs.push ({
                        field : propName
                    });
                }
            });
        };
        self.buildSectionParts = function() {
            var sectionPartDefs = self.config.sectionPartDefs, cols = [];
            if (!sectionPartDefs) {
                self.buildSectionPartDefsFromData ();
                sectionPartDefs = self.config.sectionPartDefs;
            }
        };
        self.init = function() {
            self.headerFactory = new window.kr.HeaderFactory (self);
            self.sectionFactory = new window.kr.SectionFactory (self);
            self.buildSectionParts ();
            self.configGroups.subscribe (function(a) {
                if (!a) {
                    return;
                }
                var tempArr = [];
                $.each (a, function(i, item) {
                    if (item) {
                        tempArr.push (item.field || item);
                    }
                });
                self.config.groups = tempArr;
                setTimeout (function() {
                    self.headerFactory.myDataChanged ();
                }, 100);
            });
            if (self.myData () !== undefined &&
                    self.myData ().sections !== undefined &&
                    self.myData ().sections.subscribe !== undefined) {
                self.myData ().sections.subscribe (function() {
                    if (self.$$selectionPhase) {
                        return;
                    }
                    self.maxCanvasHt (self.calcMaxCanvasHeight ());
                });
            }
            self.maxCanvasHt (self.calcMaxCanvasHeight ());
            self.refreshDomSizes ();
        };
        self.prevScrollTop = 0;
        self.prevScrollIndex = 0;
        self.adjustScrollTop = function(scrollTop, force) {
            if (self.prevScrollTop === scrollTop && !force) {
                return;
            }
            var sectionIndex = Math.floor (scrollTop /
                    self.config.sectionHeight);
            if (self.prevScrollTop < scrollTop &&
                    sectionIndex < self.prevScrollIndex + SCROLL_THRESHOLD) {
                return;
            }
            if (self.prevScrollTop > scrollTop &&
                    sectionIndex > self.prevScrollIndex - SCROLL_THRESHOLD) {
                return;
            }
            self.prevScrollTop = scrollTop;
            self.sectionFactory.UpdateViewableRange (new window.kr.Range (Math
                    .max (0, sectionIndex - EXCESS_SECTION), sectionIndex +
                    self.minSectionsToRender () + EXCESS_SECTION));
            self.prevScrollIndex = sectionIndex;
        };
        self.adjustScrollLeft = function(scrollLeft) {
            if (self.$headerContainer) {
                self.$headerContainer.scrollLeft (scrollLeft);
            }
        };
        self.resizeOnData = function(col) {
            var longest = col.minWidth;
            var arr = window.kr.utils
                    .getElementsByClassName ('col' + col.index);
            $.each (arr, function(index, elem) {
                var i;
                if (index === 0) {
                    var krHeaderText = $ (elem).find ('.krHeaderText');
                    i = window.kr.utils.visualLength (krHeaderText) + 10;
                } else {
                    var ngCellText = $ (elem).find ('.krCellText');
                    i = window.kr.utils.visualLength (ngCellText) + 10;
                }
                if (i > longest) {
                    longest = i;
                }
            });
        };
        self.fixHeaderPartIndexes = function() {
            self.$$indexPhase = true;
            var cols = self.headerParts.peek ();
            $.each (cols, function(i, col) {
                col.index = i;
            });
            self.$$indexPhase = false;
        };
        self.fixSectionPartIndexes = function() {
            self.$$indexPhase = true;
            var cols = self.sectionParts.peek ();
            $.each (cols, function(i, col) {
                col.index = i;
            });
            self.$$indexPhase = false;
        };
        self.elementsNeedMeasuring = true;
        self.headerParts = window.ko.observableArray ([]);
        self.headerParts.subscribe (function(newParts) {
            self.config.headerPartsChanged (newParts);
        });
        self.sectionParts = window.ko.observableArray ([]);
        self.sectionParts.subscribe (function(newCols) {
            self.config.sectionPartsChanged (newCols);
        });
        self.renderedHeader = window.ko.observable (self.config.header);
        self.renderedSections = window.ko.observableArray ([]);
        self.headerSection = null;
        self.headerHeight = self.config.headerHeight;
        self.sectionHeight = self.config.sectionHeight;
        self.jqueryUITheme = window.ko.observable (self.config.jqueryUITheme);
        self.footer = null;
        self.selectedItems = self.config.selectedItems;
        self.multiSelect = self.config.multiSelect;
        self.showSectionPartMenu = self.config.showSectionPartMenu;
        self.showMenu = window.ko.observable (false);
        self.configGroups = window.ko.observableArray ([]);
        self.enablePaging = self.config.enablePaging;
        self.pagingOptions = self.config.pagingOptions;
        self.sectionTemplate = self.config.sectionTemplate ||
                window.kr.defaultSectionTemplate ();
        self.headerTemplate = self.config.headerTemplate ||
                window.kr.defaultHeaderTemplate ();
        if (self.config.sectionTemplate &&
                !TEMPLATE_REGEXP.test (self.config.sectionTemplate)) {
            self.sectionTemplate = window.kr.utils
                    .getTemplatePromise (self.config.sectionTemplate);
        }
        if (self.config.headerTemplate &&
                !TEMPLATE_REGEXP.test (self.config.headerTemplate)) {
            self.headerTemplate = window.kr.utils
                    .getTemplatePromise (self.config.headerTemplate);
        }
        self.visibleHeaderParts = window.ko.computed (function() {
            var parts = self.headerParts ();
            return parts;
        });
        self.visibleSectionParts = window.ko.computed (function() {
            var cols = self.sectionParts ();
            return cols;
        });
        self.nonAggSectionParts = window.ko.computed (function() {
            return self.sectionParts ();
        });
        self.toggleShowMenu = function() {
            self.showMenu (!self.showMenu ());
        };
        self.allSelected = self.config.selectAllState;
        self.allSelected.subscribe (function(state) {
            if (self.config.beforeSelectionChange (self.myData.peek (), this)) {
                self.config.afterSelectionChange (self.selectedItems.peek (),
                        this);
            }
        });
        self.topPanelHeight = window.ko.observable (self.config.headerHeight);
        self.viewportDimHeight = window.ko.computed (function() {
            return Math.max (0, self.topPanelHeight () + 4);
        });
        self.minHeadersToRender = function() {
            var viewportH = self.viewportDimHeight () || 1;
            return Math.floor (viewportH / self.config.headerHeight);
        };
        self.minSectionsToRender = function() {
            var viewportH = self.viewportDimHeight () || 1;
            return Math.floor (viewportH / self.config.sectionHeight);
        };
        self.groupBy = function(col) {
            if (self.myData ().length < 1) {
                return;
            }
            var indx = self.configGroups ().indexOf (col);
            if (indx === -1) {
                col.isGroupedBy (true);
                self.configGroups.push (col);
                col.groupIndex (self.configGroups ().length);
            } else {
                self.removeGroup (indx);
            }
        };
        self.removeGroup = function(index) {
            var col = self.sectionParts ()[0];
            col.isGroupedBy (false);
            col.groupIndex (0);
            self.configGroups.splice (index, 1);
            self.fixGroupIndexes ();
            if (self.configGroups ().length === 0) {
                self.fixSectionPartIndexes ();
            }
        };
        self.fixGroupIndexes = function() {
            $.each (self.configGroups (), function(i, item) {
                item.groupIndex (i + 1);
            });
        };
        self.headerScrollerDim = function() {
            var newDim = new window.kr.Dimension ();
            newDim.autoFitHeight = true;
            newDim.autoFitWidth = true;
            return newDim;
        };
        self.jqueryUITheme = self.config.jqueryUITheme;
        self.maxSections = window.ko.observable (Math.max (
                self.config.pagingOptions.totalServerItems () ||
                        self.myData ().length, 1));
        self.maxSectionsDisplay = window.ko.computed (function() {
            return self.maxSections ();
        });
        self.multiSelect = window.ko
                .observable ((self.config.canSelectSections && self.config.multiSelect));
        self.selectedItemCount = window.ko.computed (function() {
            return self.selectedItems ().length;
        });
        self.init ();
    };
    window.kr.Range = function(top, bottom) {
        this.topSection = top;
        this.bottomSection = bottom;
    };
    window.kr.Header = function(entity) {
        var self = this;
        self.toggleExpand = function() {
            return;
        };
        self.collapsed = window.ko.observable (true);
        self.titleClass = window.ko.computed (function() {
            return "krHeaderTitle";
        });
        self.doclink = window.ko.computed (function() {
            return entity.doclink;
        });
        self.docname = window.ko.computed (function() {
            return entity.docname;
        });
        self.headerParts = window.ko.computed (function() {
            return entity.headerParts;
        });
        self.summaryClass = window.ko.computed (function() {
            return self.collapsed () ? "krSummaryExpanded"
                    : "krSummaryCollapsed";
        });
        self.detailsClass = window.ko.computed (function() {
            return self.collapsed () ? "krDetailsCollapsed"
                    : "krDetailsExpanded";
        });
        self.offsetTop = window.ko.observable ("0px");
        self.showDoc = window.ko.computed (function() {
            return entity.docname !== undefined;
        });
        self.showChart = window.ko.computed (function() {
            return entity.chartData !== undefined &&
                    entity.chartData.points !== undefined;
        });

        self.chartData = window.ko.computed (function() {
            setTimeout (function() {
                var color = window.d3.scale.category10 (), options = {
                    color : color,
                    graphId : "#graph-2",
                    graphdata : entity.chartData.points,
                    xLabel : "Fiscal Year",
                    yLabel : "Dollars in Millions",
                    canvaswidth : 400,
                    canvasheight : 270,
                    graphType : "bar",
                    xLabelFormat : "y",
                    yLabelFormat : "$"
                };
                if (entity.chartData !== undefined &&
                        entity.chartData.points !== undefined &&
                        entity.chartData.points.length > 0) {
                    window.kr.utils.graph (options);
                }
            }, 100);

            return entity.data !== undefined;
        });

    };
    window.kr.Section = function(entity, sectionFactory) {
        var self = this;
        self.sectionClass = window.ko.computed (function() {
            return (entity.sectionName !== undefined) ? "krSectionExpanded"
                    : "krSectionCollapsed";
        });

        self.sectionName = window.ko.computed (function() {
            return entity.sectionName;
        });
        self.summarySectionParts = window.ko.computed (function() {
            return entity.summarySectionParts;
        });
        self.detailsSectionParts = window.ko.computed (function() {
            return entity.detailsSectionParts;
        });
        self.header = window.ko.observable (entity.header);
        self.headerParts = window.ko.computed (function() {
            return (entity.header !== undefined) ? entity.header.headerParts
                    : [];
        });
        self.chartData = window.ko.computed (function() {
            return (entity.header !== undefined) ? entity.header.points : [];
        });
        self.showSummary = window.ko.computed (function() {
            return entity.summary !== undefined;
        });
        self.showLink = window.ko.computed (function() {
            return entity.doclink !== undefined;
        });
        self.opendoc = entity.opendoc;
        self.doclink = window.ko.observable (entity.doclink);
        self.docname = window.ko.observable (entity.docname);
        self.docUri = window.ko.observable (entity.docUri);
        self.summary = window.ko.observable (entity.summary);
        self.details = window.ko.observable (entity.details);
        self.collapsed = window.ko.observable (true);
        self.entity = entity;
        self.children = entity.children;
        self.warningIconClass = window.ko
                .computed (function() {
                    return self.collapsed () ? "glyphicon glyphicon-warning-sign krWarningIconColor"
                            : "";
                });
        self.infoIconClass = window.ko
                .computed (function() {
                    return self.collapsed () ? "glyphicon glyphicon-info-sign krInfoIconColor"
                            : "";
                });
        self.openCloseGlyphIconClass = window.ko
                .computed (function() {
                    return self.collapsed () ? "glyphicon glyphicon-chevron-right krExpandIconColor"
                            : "glyphicon glyphicon-chevron-down krExpandIconColor";
                });
        self.summaryClass = window.ko.computed (function() {
            return self.collapsed () ? "krSummaryExpanded"
                    : "krSummaryCollapsed";
        });
        self.detailsClass = window.ko.computed (function() {
            return self.collapsed () ? "krDetailsCollapsed"
                    : "krDetailsExpanded";
        });
        self.continueSelection = function(event) {
        };
        self.toggleExpand = function() {
            var c = self.collapsed ();
            self.collapsed (!c);
            sectionFactory.renderedChange ();
        };
        if (self.entity[SELECTED_PROP] === undefined) {
            self.entity[SELECTED_PROP] = false;
        }
        self.sectionIndex = window.ko.observable (0);
        self.offsetTop = window.ko.observable ("0px");
        self.sectionDisplayIndex = 0;
        self.propertyCache = {};
        self.getProperty = function(path) {
            return self.propertyCache[path] ||
                    (self.propertyCache[path] = window.kr.utils.evalProperty (
                            self.entity, path));
        };
    };
    window.kr.domUtilityService = {
        AssignReportContainers : function(rootEl, report) {
            report.$root = $ (rootEl);
            report.$topPanel = report.$root.find (".krTopPanel");
            report.$headerContainer = report.$topPanel
                    .find (".krHeaderContainer");
            report.$headerScroller = report.$topPanel
                    .find (".krHeaderScroller");
            report.$headers = report.$headerScroller.children ();
            report.$viewport = report.$root.find (".krViewport");
            report.$canvas = report.$viewport.find (".krCanvas");
            report.$footerPanel = report.$root.find (".ngFooterPanel");
            window.kr.domUtilityService.UpdateReportLayout (report);
        },
        UpdateReportLayout : function(report) {
            var scrollTop = report.$viewport.scrollTop ();
            report.elementDims.rootMaxH = report.$root.height ();
            report.refreshDomSizes ();
            report.adjustScrollTop (scrollTop, true);
        },
        ScrollH : 17,
        ScrollW : 17,
        LetterW : 10
    };
} (window));