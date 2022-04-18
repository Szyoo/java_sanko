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
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        self.label.text = "Hello"
    }

    @IBAction func pressButton(_ sender: Any) {
        self.label.text = "Pressed the button"
    }
    
}

