// Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"

let apiKey = "xxx"

// Do any additional setup after loading the view, typically from a nib.
let location = "37.8267,-122.423"
let baseURL = NSURL(string: "https://api.forecast.io/forecast/\(apiKey)/")
let foreCaseURL = NSURL(string: location, relativeToURL: baseURL)

let weatherData = NSData.dataWithContentsOfURL(foreCaseURL, options: nil, error: nil)

