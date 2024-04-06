Validator.plugin("numberonly", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		return /^\d+$/.test(el.value);
	}
});

Validator.plugin("textRequired", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		return /^(?!\s)(?!.*\s$)[a-zA-Z0-9\s_-]+$/.test(el.value);
	}
});

Validator.plugin("startDateValidation", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		var startDate = new Date(el.value);
		        
		var currentDate = new Date();
		if (startDate <= currentDate) {
			return false;
		}
		return true;
	}
});

Validator.plugin("endDateValidation", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		var endDate = new Date(el.value);
		var startDate = new Date($('input[name="startDateTime"]').val());
		if (startDate >= endDate) {
			return false;
		}
		return true;
	}
});

Validator.plugin("startEndDateDurationValidation", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		var endDate = new Date($('input[name="endDateTime"]').val());
		var startDate = new Date($('input[name="startDateTime"]').val());
		var maxDuration = 30;
		var maxEndDate = new Date(startDate);
        maxEndDate.setDate(maxEndDate.getDate() + maxDuration);
		if (endDate > maxEndDate) {
			return false;
		}
		return true;
	}
});


Validator.plugin("textDescriptionRequired", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		return /^(?! )[\w\s.,?!-]+(?<! )$/.test(el.value);
	}
});
Validator.plugin("contactValidation", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		return /^[6-9]\d{9}$/.test(el.value);
	}
});

Validator.plugin("usernameFormat", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{6,}$/.test(el.value);
	}
});

Validator.plugin("passwordValidation", {
	install() {
		console.log('plugin installed');
	},
	validate(el, attribute) {
		return /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()-+])[A-Za-z\d!@#$%^&*()-+]{8,20}$/.test(el.value);
	}
});

var validator = new Validator(document.querySelector("form"), {
	autoScroll: true,
	showValid: true
});