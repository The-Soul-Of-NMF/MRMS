/**
 * Created by Hugh on 2015/7/3 0003.
 * Plugin: TimeLine
 * Description: A timeline to describe meeting room's situation of occupation
 */
(function ($) {
	var opts;
	
    function rm_str_px(str){
        return parseInt(str.split("px")[0]);
    }
	//plugin definition
	$.fn.timeline = function(options){
		// build main options before element iteration
		opts = $.extend({}, $.fn.timeline.defaults, options);
		// iterate and reformat each matched element
		return this.each(function () {
			init($(this), opts);
		});
		
	}

	// private function
	function init (element, options) {
		validateOptions(options)
		$(element).generate(options);

	}
	// validate options whether is valid
	function validateOptions(options){

	}
	
	$.fn.generate = function (options) {
		$(this).css({
			"width": options.circleDiameter
		});

		var interval = options.interval;
		var circle_num = parseInt((options.endTime - options.startTime) * 60 /interval) + 1;

		var timeline = $("<div></div>");
		for (var i = 0; i < circle_num; i++) {
			timeline.appendCircle(options, i);
			if (i != circle_num - 1)
				timeline.appendLine(options, i);
		}

		$(this).append(timeline)

		options.callback();
	}
	
	$.fn.appendCircle = function (options, count) {
		var circle = $("<div class='timeline_circle'></div>")
		var little_circle = $("<div class='timeline_little_circle'></div>")
		circle.attr("count", count);
		circle.css(
			{
				"width": options.circleDiameter,
				"height": options.circleDiameter,
				"border-radius": options.circleDiameter,
				"background": options.circleBackground
			}
		);

		var little_circle_diameter = parseInt(options.circleDiameter.split('px')[0])/2;
		little_circle.css({
			"width": little_circle_diameter + "px",
			"height": little_circle_diameter + "px",
			"border-radius": little_circle_diameter + "px",
			"left": little_circle_diameter/2 + "px",
			"top": little_circle_diameter/2 + "px"
		});
		circle.hover(function () {
			little_circle.css({
				"background": "rgba(255,255,255,0.8)",
				"transition": "background 0.5s"
			})
		}, function () {
			little_circle.css({
				"background": "rgba(255,255,255,0.3)",
				"transition": "background 0.5s"
			})
		})
		circle.append(little_circle);

		var time_tip = $("<div class='timeline_time_tip'></div>");
		var hour = parseInt(options.startTime + count*options.interval/60);
		var minute = count*options.interval%60;
		var time_tip_text = hour + ":" + minute;
		time_tip.text(time_tip_text)
		circle.append(time_tip);


		time_tip.css({
			"height": options.circleDiameter,
			"line-height": options.circleDiameter,
			"margin": "0px "+options.circleDiameter,
			"right": options.circleDiameter
		});
		if(minute != 0){
			time_tip.css({
				"display": "none"
			});

			var handle;
			circle.hover(function(){
				if (handle){
					window.clearInterval(handle)
				}
				time_tip.stop(true)
				time_tip.fadeIn(100)
			}, function () {
				handle = setInterval(function () {
					time_tip.fadeOut(2000)
				},500)
			})
		}else{
			time_tip.text(time_tip_text + "0");
			time_tip.addClass("timeline_time_tip_main")
		}
		$(this).append(circle);
	}
	
	$.fn.appendLine = function (options, count) {
		var line = $("<div class='timeline_line'></div>")
		line.attr("count", count);
		if(options.type != "horizontal"){
			line.css({
				"width": options.lineWidth,
				"margin": "auto",
				"height": options.lineLength,
				"background": options.lineBackground
			});
		}

		$(this).append(line);
	}

	
	// define add a meeting function
	// options must include:
	// startTime, duration, message,url
	// startTime eg: 9:30
	$.fn.meeting = function(options){
		var start_time = options.startTime.split(":");
		var start_time_hour = parseInt(start_time[0]);
		var start_time_minute = parseInt(start_time[1]);
		var duration = options.duration;

		var start_circle = parseInt((((start_time_hour-opts.startTime) * 60) + start_time_minute) / opts.interval);
		var line_count = parseInt(duration / opts.interval);

		$(this).find(".timeline_circle[count='"+ start_circle + "']").each(function ()
		{
			var border = $("<div class='timeline_circle_border'></div>");

			var border_radius = parseInt(opts.circleDiameter.split('px')[0]);
			border.css({
				"width": border_radius*2.5 + "px",
				"height": border_radius*1.5 + "px",
				"border-radius": 3*border_radius + "px",
				"border": border_radius/2 + "px solid rgba(151,0,255,0.5)",
				"left": -border_radius/4*3 + "px",
				"top": -border_radius/4 + "px",
				"border-bottom": 0,
				"border-top": 0
			});
			$(this).append(border)

			if(options.message)
				$(this).appendMessageBox(options)
			$(this).nextAll(".timeline_line").each(function () {
				if (parseInt($(this).attr("count")) < start_circle + line_count){
					$(this).css({
						"background": opts.occupyLineBackground
					});
				}
			});
		});

		$(this).find(".timeline_circle[count='"+ (start_circle+line_count) + "']").each(function ()
		{
			var border = $("<div class='timeline_circle_border'></div>");

			var border_diameter = parseInt(opts.circleDiameter.split('px')[0]);
			border.css({
				"width": border_diameter*1.5 + "px",
				"height": border_diameter*2.5 + "px",
				"border-radius": 3*border_diameter + "px",
				"border": border_diameter/2 + "px solid rgba(151,0,255,0.5)",
				"left": -border_diameter/4 + "px",
				"bottom": -border_diameter/4*3 + "px",
				"border-left": 0,
				"border-right": 0
			});
			$(this).append(border)
		});

	}

	$.fn.appendMessageBox = function (options) {
		var message = options.message;
		var message_box = $("<div class='timeline_message_box'></div>");
		var triangle = $("<div class='box_triangle'></div>");
		message_box.text(message);
		message_box.append(triangle);

		var width = message.length * parseInt(opts.messageFontSize.split('px')[0]);

		message_box.css({
			"left": opts.circleDiameter,
			"margin": "0 50px",
			"background": opts.messageBoxBackground,
			"font-size": opts.messageFontSize,
			"width": "150px"
			
		})
		triangle.css({
			"border-right": "10px solid " + opts.messageBoxBackground
		});

		if (options.url)
			message_box.click(function () {
				window.open(options.url)
			})

		$(this).append(message_box)
	}
	
	// plugin defaults
	$.fn.timeline.defaults = {
		type: "vertical",
		circleDiameter: "20px",
		lineLength: "50px",
		lineWidth: "5px",
		circleBackground: "#2280D3",
		lineBackground: "#06A347",
		occupyLineBackground: "#FF4C15",
		messageBoxBackground: "#BEBDFF",
		messageFontSize: "15px",
		startTime: 8,			// * o'clock
		endTime: 23,
		interval: 15,			//unit: minute
		message: false,
		callback: function(){}
	}
}
)(jQuery);