<!--

	function dirname (path) {
		return path.replace(/\/[^\/]*\/?$/, '');
	}
	
	// POPUP WINDOW
	function openpopup(popurl, w, h, sizable) {
		str = 'width='+(w+20)+',height='+(h+30);
		if ( sizable != true ) {
			str = str + ',scrollbars=no,resizable=no,status=no';
		} else {
			str = str + ',scrollbars=yes,resizable=yes,status=yes';
		}
		window.open(popurl,'',str);
	}
	
	// ARRAY PROTOTYPES
	Array.prototype.contains = function (element) {
		for ( var i=0; i<this.length; i++ ) {
			if ( this[i]==element ) {
				return i;
			}
		}
		return false;
	}
	
	Array.prototype.remove = function (element) {
		var result = false;
		var array = [];
		for (var i = 0; i < this.length; i++) {
			if (this[i] == element) {
				result = true;
			} else {
				array.push(this[i]);
			}
		}
		this.length = 0;
		for (var i = 0; i < array.length; i++) {
			this.push(array[i]);
		}
		array = null;
		return result;
	};
	
	Array.prototype.addUnique = function (element) {
		if (this.contains(element) === false) {
			this.push(element);
		}
	};
	
	// Read the JavaScript cookies tutorial at:
	// http://www.netspade.com/articles/javascript/cookies.xml
	
	// SET COOKIE
	function setCookie(name, value, days, expires, path, domain, secure) {
		if (days) {
			expires = new Date();
			expires.setTime(expires.getTime()+(days*24*60*60*1000));
		}
		
		document.cookie= name + "=" + escape(value) +
			((expires) ? "; expires=" + expires.toGMTString() : "") +
			((path) ? "; path=" + path : "") +
			((domain) ? "; domain=" + domain : "") +
			((secure) ? "; secure" : "");
	}
	
	// GET COOKIE
	function getCookie(name) {
		var dc = document.cookie;
		var prefix = name + "=";
		var begin = dc.indexOf("; " + prefix);
		if (begin == -1) {
			begin = dc.indexOf(prefix);
			if (begin != 0) return null;
		} else {
			begin += 2;
		}
		var end = document.cookie.indexOf(";", begin);
		if (end == -1) {
			end = dc.length;
		}
		return unescape(dc.substring(begin + prefix.length, end));
	}
	
	// DELETE COOKIE
	function deleteCookie(name, path, domain) {
		if (getCookie(name)) {
			document.cookie = name + "=" + 
				((path) ? "; path=" + path : "") +
				((domain) ? "; domain=" + domain : "") +
				"; expires=Thu, 01-Jan-70 00:00:01 GMT";
		}
	}
	
	// TOGGLE BLOCK
	function toggleBlock(id, forceHidden) {
		forceHidden = (forceHidden==undefined) ? false : forceHidden;
		
		// Variables
		var toggleObj;
		var linkObj;
		
		// Get Element
		if (document.getElementById) {
			// this is the way the standards work: Safari, FireFox
			toggleObj = document.getElementById('toggle'+id);
			linkObj = document.getElementById('link'+id);
		} else if (document.all) {
			// this is the way old msie versions work
			toggleObj = document.all['toggle'+id];
			linkObj = document.all['link'+id];
			
		} else if (document.layers) {
			// this is the way nn4 works
			toggleObj = document.layers['toggle'+id];
			linkObj = document.layers['link'+id];
		}
		
		// Toggle
		var cookieStr = getCookie('toggledItems');
		var toggleArr = Array();
		if (cookieStr) {
			toggleArr = cookieStr.split(',');
		}
		
		if (toggleObj) {
			styleObj = toggleObj.style;
			if (styleObj.display != "none" || forceHidden==true) {
				// HIDE
				toggleArr.addUnique(id);
				styleObj.display = "none";
				if (linkObj) {
					twistyObj = linkObj.getElementsByTagName('img')[0];
					
					if (twistyObj) {
						twistyObj.setAttribute('src', dirname(twistyObj.getAttribute('src')) + '/plus.gif');
						twistyObj.setAttribute('alt','[+]');
					} else {
						linkObj.innerHTML = "[+]";
					}
				}
			} else {
				// SHOW
				toggleArr.remove(id);
				styleObj.display = "block";
				if (linkObj) {
					twistyObj = linkObj.getElementsByTagName('img')[0];
					
					if (twistyObj) {
						twistyObj.setAttribute('src', dirname(twistyObj.getAttribute('src')) + '/minus.gif');
						twistyObj.setAttribute('alt','[-]');
					} else {
				linkObj.innerHTML = "[-]";
			}
				}
			}
			setCookie('toggledItems', toggleArr.toString(),30);
		}	
	}
	
	// DEFAULT PAGE INIT FUNCTION
	function init() {
		var cookieStr = getCookie('toggledItems');
		var toggleArr = Array();
		
		if (cookieStr) {
			toggleArr = cookieStr.split(',');
			for ( var i=0; i<toggleArr.length; i++ ) {
				toggleBlock(toggleArr[i], true);
			}
		}
	}
	
	function addEvent(elm, evType, fn, useCapture){
		if (elm.addEventListener) {
			elm.addEventListener(evType, fn, useCapture);
			return true;
		} else if (elm.attachEvent) {
			var r = elm.attachEvent('on' + evType, fn);
			return r;
		} else {
			elm['on' + evType] = fn;
		}
	}

	addEvent(window, 'load', init, false);
-->
