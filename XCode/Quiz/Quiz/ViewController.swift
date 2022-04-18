//
//  ViewController.swift
//  Quiz
//
//  Created by Szyoo on 2022/4/18.
//  Copyright © 2022 SHENGZHE YANG. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var label: UILabel!
    
    var date = Date()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        self.label.text = self.date.description
    }
    
    @IBAction func pressButton(_ sender: Any) {
        self.date.addTimeInterval(60*60*3)
        self.label.text = self.date.description
    }
    
}

