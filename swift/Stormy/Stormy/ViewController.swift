//
//  ViewController.swift
//  Stormy
//
//  Created by Harry James Potter on 05/10/2014.
//  Copyright (c) 2014 Treehouse. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    private let apiKey = ""

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let coordinates = "37.8267,-122.423"
        let     baseURL = NSURL(string: "https://api.forecast.io/forecast/\(apiKey)/")
        let forecastURL = NSURL(string: coordinates, relativeToURL: baseURL)
        
//        let weatherData = NSData.dataWithContentsOfURL(forecastURL, options: nil, error: nil)
//        println(weatherData)
        
        let sharedSession = NSURLSession.sharedSession()
        let downloadTask: NSURLSessionDownloadTask = sharedSession.downloadTaskWithURL(forecastURL,
        completionHandler:
            { (location: NSURL!, response: NSURLResponse!, error: NSError!) -> Void in

                if (error == nil)
                {
                    let dataObject  = NSData(contentsOfURL: location)
                    let weatherDict: NSDictionary = NSJSONSerialization.JSONObjectWithData(dataObject, options: nil, error: nil) as NSDictionary
                    println(weatherDict)
                }
                
            })
        
        downloadTask.resume()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

