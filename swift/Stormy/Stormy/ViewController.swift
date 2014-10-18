//
//  ViewController.swift
//  Stormy
//
//  Created on 05/10/2014.
//  Copyright (c) 2014 Treehouse. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var iconView: UIImageView!
    @IBOutlet weak var currentTimeLabel: UILabel!
    @IBOutlet weak var temperatureLabel: UILabel!
    @IBOutlet weak var humidityLabel: UILabel!
    @IBOutlet weak var precipitationLabel: UILabel!
    @IBOutlet weak var summaryLabel: UILabel!
    @IBOutlet weak var refreshButton: UIButton!
    @IBOutlet weak var refreshActivityIndicator: UIActivityIndicatorView!
    
    
    private let apiKey = "208abf6b549aefd27534dd6ccad42846"

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        refreshActivityIndicator.hidden = true
        getCurrentWeatherData()
    }
    
    func getCurrentWeatherData() -> Void {
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
                    
                    let currentWeather = CurrentWeather(weatherDict: weatherDict)
                    
                    dispatch_async(dispatch_get_main_queue(), { () -> Void in
                        self.temperatureLabel.text = "\(currentWeather.temperature)"
                        self.iconView.image = currentWeather.icon!
                        self.currentTimeLabel.text = "At \(currentWeather.timeNow!) it is"
                        self.humidityLabel.text = "\(currentWeather.humidity)"
                        self.precipitationLabel.text = "\(currentWeather.precipProb)"
                        self.summaryLabel.text = "\(currentWeather.summary)"
                        
                        self.refreshActivityIndicator.stopAnimating()
                        self.refreshActivityIndicator.hidden = true
                        self.refreshButton.hidden = false
                    })
                } else {
                    let networkIssueController = UIAlertController(title: "Error", message: "Unable to load data. Connectivity error!", preferredStyle: .Alert)
                    let okButton = UIAlertAction(title: "OK", style: .Default, handler: nil)
                    let cancelButton = UIAlertAction(title: "Cancel", style: .Default, handler: nil)
                    
                    networkIssueController.addAction(okButton)
                    networkIssueController.addAction(cancelButton)
                    
                    self.presentViewController(networkIssueController, animated: true, completion: nil)
                    
                    dispatch_async(dispatch_get_main_queue(), { () -> Void in
                        self.refreshActivityIndicator.stopAnimating()
                        self.refreshActivityIndicator.hidden = true
                        self.refreshButton.hidden = false
                    })
                }
                
        })
        
        downloadTask.resume()    }

    @IBAction func refresh() {
        refreshButton.hidden = true
        refreshActivityIndicator.hidden = false
        refreshActivityIndicator.startAnimating()
        getCurrentWeatherData()
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

