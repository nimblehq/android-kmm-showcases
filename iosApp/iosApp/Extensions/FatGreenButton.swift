//
//  Buttons.swift
//  iosApp
//
//  Created by Edgars Simanovskis on 22/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

struct FatGreenButton: ButtonStyle {
    func makeBody(configuration: Configuration) -> some View {
        configuration.label
            .frame(maxWidth: .infinity)
            .font(.title2)
            .foregroundColor(.white)
            .padding()
            .background(Color.greenColor)
            .clipShape(RoundedRectangle(cornerRadius: 20))
    }
}
