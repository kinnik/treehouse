//
//  ViewController.swift
//  Stormy
//
//  Created by Harry James Potter on 05/10/2014.
//  Copyright (c) 2014 Treehouse. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    private let apiKey = "xxx"

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        let location = "37.8267,-122.423"
        let baseURL = NSURL(string: "https://api.forecast.io/forecast/\(apiKey)/")
        let foreCaseURL = NSURL(string: location, relativeToURL: baseURL)
        
        let weatherData = NSData.dataWithContentsOfURL(foreCaseURL, options: nil, error: nil)
        println(weatherData)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

