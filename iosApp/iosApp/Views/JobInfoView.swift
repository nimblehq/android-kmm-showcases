//
//  JobInfoView.swift
//  iosApp
//
//  Created by Edgars Simanovskis on 24/3/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI

struct JobInfoView: View {
    var price = "80-95 Baht"
    var date = "25 Mar 2022"
    var time = "6:00-12:00"
    var distance = "33 km"
    var area = "70 m2"
    var address = "123 NimbleHq"
    var cropType = "Corn"
    var message = "Message to pilot"
    
    var body: some View {
        ScrollView(.vertical, showsIndicators: false) {
            VStack(alignment: .leading) {
                // Price by area HStack
                HStack {
                    Text("Price by area")
                        .font(.subheadline)
                        .foregroundColor(Color.greyColor)
                    Spacer()
                    Text(price)
                        .font(.headline)
                        .fontWeight(.bold)
                        .foregroundColor(.greenColor)
                }
                .padding(.bottom)
                
                
                Text("Date time")
                    .font(.headline)
                    .bold()
                HStack {
                    Text(date)
                        .font(.headline)
                        .bold()
                    Spacer()
                    Text(time)
                        .font(.footnote)
                        .foregroundColor(Color.greyColor)
                }
                .frame(maxWidth: .infinity)
                .padding()
                .background(RoundedRectangle(cornerRadius: 20)
                                .fill(Color.white)
                )
                .compositingGroup()
                .shadow(color: Color.greyColor, radius: 1, x: 0, y: 0.8)
                
                
                Text("Plot Information")
                    .font(.headline)
                    .bold()
                    .padding(.top)
                VStack(alignment: .leading) {
                    HStack(spacing: 100) {
                        VStack(spacing: 10) {
                            Text("Distance")
                                .font(.body)
                                .foregroundColor(Color.greyColor)
                            Text(distance)
                                .font(.body)
                                .foregroundColor(.greenColor)
                        }
                        VStack(spacing: 10) {
                            Text("Area")
                                .foregroundColor(Color.greyColor)
                            Text(area)
                                .foregroundColor(.greenColor)
                        }
                    }
                    .frame(maxWidth: .infinity)
                    .padding(.bottom)
                    
                    VStack(alignment: .leading, spacing: 6) {
                        Text("Address")
                            .font(.subheadline)
                            .foregroundColor(Color.greyColor)
                        Text(address)
                            .font(.subheadline)
                            .padding(.bottom, 4)
                        
                        Text("Crop type")
                            .font(.subheadline)
                            .foregroundColor(Color.greyColor)
                        Text(cropType)
                            .font(.subheadline)
                    }
                }
                .padding()
                .background(RoundedRectangle(cornerRadius: 30)
                                .fill(Color.white)
                )
                .compositingGroup()
                .shadow(color: Color.greyColor, radius: 1, x: 0, y: 1)
                
                Text("Message to pilot")
                    .bold()
                    .padding(.vertical, 4)
                Text(message)
                    .font(.subheadline)
                
                Spacer()
            }
            .padding()
            .frame(maxWidth: .infinity)
        }
    }
}
