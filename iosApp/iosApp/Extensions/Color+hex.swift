//
//  Color+hex.swift
//  iosApp
//
//  Created by Edgars Simanovskis on 22/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

extension Color {
    init(hex: UInt, alpha: Double = 1) {
        self.init(
            .sRGB,
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
            opacity: alpha
        )
    }
    
    static let blackColor = Color(hex: 0x171923)
    static let greenColor = Color(hex: 0x2BC65D)
    static let greyColor = Color(hex: 0xA0AEC0)
    static let offWhite = Color(hex: 0xFAFAFA)
}
