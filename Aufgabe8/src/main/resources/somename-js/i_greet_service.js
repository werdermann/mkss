/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

/** @module somename-js/i_greet_service */
var utils = require('vertx-js/util/utils');
var Vertx = require('vertx-js/vertx');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JIGreetService = services.IGreetService;

/**
 @class
*/
var IGreetService = function(j_val) {

  var j_iGreetService = j_val;
  var that = this;

  /**

   @public
   @param name {string} 
   @return {string}
   */
  this.greet = function(name) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      return j_iGreetService["greet(java.lang.String)"](name);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   */
  this.close = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_iGreetService["close()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_iGreetService;
};

/**

 @memberof module:somename-js/i_greet_service
 @param vertx {Vertx} 
 @param address {string} 
 @return {IGreetService}
 */
IGreetService.createProxy = function(vertx, address) {
  var __args = arguments;
  if (__args.length === 2 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'string') {
    return utils.convReturnVertxGen(JIGreetService["createProxy(io.vertx.core.Vertx,java.lang.String)"](vertx._jdel, address), IGreetService);
  } else throw new TypeError('function invoked with invalid arguments');
};

// We export the Constructor function
module.exports = IGreetService;