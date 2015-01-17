var happinessDirectives = angular.module('happinessDirectives', []);

happinessDirectives.directive('graphDirective', function() {
    return {
        restrict: 'A',
        link: function($scope, element, attrs) {
            var votes = [
                {"voteValue": 1, "voteCount": 1},
                {"voteValue": 2, "voteCount": 1},
                {"voteValue": 3, "voteCount": 2},
                {"voteValue": 4, "voteCount": 3},
                {"voteValue": 5, "voteCount": 27}
            ];

            var data = votes.slice();

            var voteValueFn = function(d) { return d.voteValue; };
            var voteCountFn = function(d) { return d.voteCount; };

            var width = 420,
                barHeight = 20;

            var x = d3.scale.linear()
                .domain([0, d3.max(data)])
                .range([0, width]);

            var chart = d3.select(".chart")
                .attr("width", width)
                .attr("height", barHeight * data.length);

            var bar = chart.selectAll("g")
                .data(data)
                .enter().append("g")
                .attr("transform", function(d) { return "translate(0," + voteValueFn(d) * barHeight + ")"; });

            bar.append("rect")
                .attr("width", function(d) { return voteCountFn(d) * 10; })
                .attr("height", barHeight - 1);

//            bar.append("text")
//                .attr("x", function(d) { return x(d) - 3; })
//                .attr("y", barHeight / 2)
//                .attr("dy", ".35em")
//                .text(function(d) { return voteValueFn(d); });
        }
    };
});