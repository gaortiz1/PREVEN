<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<div id="content" style="margin: 20px">
    <stepset next-text="Next" previous-text="Previous" submit-text="Submit" submit-action="testSubmit">
        <form>
            <step title="Select your size">
                <div class="control-group">
                    <div class="controls">
                        <label class="radio" for="size-0">
                            <input name="size" id="size-0" value="Small" checked="checked" type="radio">Small</label>
                        <label class="radio" for="size-1">
                            <input name="size" id="size-1" value="Medium" type="radio">Medium</label>
                        <label class="radio" for="size-2">
                            <input name="size" id="size-2" value="Large" type="radio">Large</label>
                        <label class="radio" for="size-3">
                            <input name="size" id="size-3" value="Extra Large" type="radio">Extra Large</label>
                    </div>
                </div>
            </step>
            <step title="Select your toppings">
                <div class="control-group">
                    <div class="controls">
                        <label class="checkbox" for="toppings-0">
                            <input name="toppings" id="toppings-0" value="Pepperoni" type="checkbox">Pepperoni</label>
                        <label class="checkbox" for="toppings-1">
                            <input name="toppings" id="toppings-1" value="Extra Cheese" type="checkbox">Extra Cheese</label>
                        <label class="checkbox" for="toppings-2">
                            <input name="toppings" id="toppings-2" value="Mushrooms" type="checkbox">Mushrooms</label>
                        <label class="checkbox" for="toppings-3">
                            <input name="toppings" id="toppings-3" value="Green Pepper" type="checkbox">Green Pepper</label>
                        <label class="checkbox" for="toppings-4">
                            <input name="toppings" id="toppings-4" value="Pineapple" type="checkbox">Pineapple</label>
                        <label class="checkbox" for="toppings-5">
                            <input name="toppings" id="toppings-5" value="Ham" type="checkbox">Ham</label>
                        <label class="checkbox" for="toppings-6">
                            <input name="toppings" id="toppings-6" value="Bacon" type="checkbox">Bacon</label>
                    </div>
                </div>
            </step>
            <step title="Delivery Info" description="Who are we sending this to?">
                <div class="control-group">
                    <label class="control-label" for="name">Name</label>
                    <div class="controls">
                        <input id="name" name="name" placeholder="Austin Keeley" class="input-xlarge" required="" type="text" ng-model="name">
                    </div>
                </div>
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="address">Address</label>
                    <div class="controls">
                        <input id="address" name="address" placeholder="123 Fake Street." class="input-xlarge" required="" type="text" ng-model="address">
                    </div>
                </div>
                <!-- Text input-->
                <div class="control-group">
                    <label class="control-label" for="phoneNumber">Phone Number</label>
                    <div class="controls">
                        <input id="phoneNumber" name="phoneNumber" placeholder="555-555-5555" class="input-xlarge" required="" type="text" ng-model="phoneNumber">
                    </div>
                </div>
            </step>
        </form>
    </stepset>
</div>
<script type="text/ng-template" id="partials/stepset.html">
<div>
  <form name="stepForm">
    <div id="steps" ng-transclude>
    </div>

    <div id="navBar">
      <span>
        <button class="btn" ng-click="previous()" ng-disabled="!previousEnabled">{{previousText}}</button>
        <button class="btn" ng-click="next()" ng-disabled="!nextEnabled">{{nextText}}</button>
        <button class="btn btn-success" ng-click="submit()" ng-disabled="stepForm.$invalid || !submitEnabled">{{submitText}}</button>
      </span>
    </div>
  </form>
</div>
</script>
<script type="text/ng-template" id="partials/step.html">
<div ng-show="isDisplayed">
    <h1>{{title}}</h1>
    <p>{{description}}</p>
    <div ng-transclude></div>
</div>
</script>