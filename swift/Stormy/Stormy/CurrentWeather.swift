//
//  CurrentWeather.swift
//  Stormy
//
//  Created on 14/10/2014.
//  Copyright (c) 2014 Treehouse. All rights reserved.
//

import Foundation
import UIKit

struct CurrentWeather {
    
    var timeNow:     String?
    var temperature: Int
    var humidity:    Double
    var precipProb:  Double
    var summary:     String
    var icon:        UIImage?
    
    init(weatherDict: NSDictionary) {
        let currentWeatherDict = weatherDict["currently"] as NSDictionary
        
        temperature = currentWeatherDict["temperature"]         as Int
        humidity    = currentWeatherDict["humidity"]            as Double
        precipProb  = currentWeatherDict["precipProbability"]   as Double
        summary     = currentWeatherDict["summary"]             as String
        
        let currentTime: Int = currentWeatherDict["time"]       as Int
        timeNow      = dateStringFromUnixTime(currentTime)
        
        let iconString = currentWeatherDict["icon"]             as String
        icon = weatherIconFromString(iconString)
    }
    
    func dateStringFromUnixTime(unixTime: Int) -> String {
        let timeInSeconds = NSTimeInterval(unixTime)
        let weatherDate   = NSDate(timeIntervalSince1970: timeInSeconds)
        let dateFormatter = NSDateFormatter()
        dateFormatter.timeStyle = .ShortStyle
        
        return dateFormatter.stringFromDate(weatherDate)
    }
    
    func weatherIconFromString(stringIcon: String) -> UIImage? {
        var imageName: String
        
        switch stringIcon {
        case "clear-day", "clear-night", "rain", "snow", "sleet", "wind", "fog", "cloudy":
            imageName = stringIcon
            
        case "partly-cloudy-day":
            imageName = "partly-cloudy"
        case "partly-cloudy-night":
            imageName = "cloudy-night"
        default:
            imageName = stringIcon
        }
        
        let iconImage = UIImage(named: imageName)
        
        return iconImage
    }
}